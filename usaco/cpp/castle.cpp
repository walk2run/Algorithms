/*
LANG: C++
PROG: castle
*/
#include <fstream>
#include <vector>
#include <algorithm>
using namespace std;

struct Module
{
	int label;
	bool north, south, west, east;	// through
	void init(int wall)
	{
		label = 0;
		west = !(wall & 1);
		north = !(wall & 2);
		east = !(wall & 4);
		south = !(wall & 8);
	}
};

struct MaxRemove
{
	int size, i, j;
	char direction;
};

Module map[51][51];
int n, m, label = 0;
vector<int> sizes(1);

void dfs(int i, int j)
{
	if (map[i][j].label == 0)
	{
		sizes[label]++;
		map[i][j].label = label;
		if (map[i][j].north) dfs(i-1, j);
		if (map[i][j].south) dfs(i+1, j);
		if (map[i][j].west) dfs(i, j-1);
		if (map[i][j].east) dfs(i, j+1);
	}
}

void print(ofstream &fout)
{
	int i, j;
	for (i = 1; i <= n; i++)
	{
		for (j = 1; j <= m; j++)
			fout << map[i][j].label << ' ';
		fout << endl;
	}
}

int main()
{
	int i, j, wall, size;
	MaxRemove maxr;

	ifstream fin("castle.in");
	ofstream fout("castle.out");

	fin >> m >> n;
	for (i = 1; i <= n; i++)
		for (j = 1; j <= m; j++)
		{
			fin >> wall;
			map[i][j].init(wall);
		}

	for (i = 1; i <= n; i++)
		for (j = 1; j <= m; j++)
			if (map[i][j].label == 0)
			{
				label++;
				sizes.push_back(0);
				dfs(i, j);
			}

	//print(fout);
	fout << label << endl;
	fout << *max_element(sizes.begin()+1, sizes.end()) << endl;
	
	maxr.size = 0;
	for (j = 1; j <= m; j++)
		for (i = n; i > 0; i--)
		{
			if (i > 1)
				if (map[i][j].label != map[i-1][j].label)
				{
					size = sizes[map[i][j].label] + sizes[map[i-1][j].label];
					if (size > maxr.size)
					{
						maxr.size = size;
						maxr.i = i;
						maxr.j = j;
						maxr.direction = 'N';
					}
				}
			if (j < m)
				if (map[i][j].label != map[i][j+1].label)
				{
					size = sizes[map[i][j].label] + sizes[map[i][j+1].label];
					if (size > maxr.size)
					{
						maxr.size = size;
						maxr.i = i;
						maxr.j = j;
						maxr.direction = 'E';
					}
				}
		}

	fout << maxr.size << endl;
	fout << maxr.i << ' ' << maxr.j << ' ' << maxr.direction << endl;

	return 0;
}