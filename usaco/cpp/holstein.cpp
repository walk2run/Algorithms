/*
LANG: C++
PROG: holstein
*/
#include <fstream>
using namespace std;

int g, v, minCount;
unsigned minBin;
int vit[25];	// total vitamins of chosen feed
int req[25], feed[15][25];

int bitCount(unsigned int n)
{
	unsigned int c = 0;
	for (c = 0; n; c++)
		n &= n - 1;
	return c;
}

void search(int depth, unsigned bin)
{
	int i, count;
	unsigned newBin;
	bool enough;

	// choose
	newBin = bin | (1 << depth);
	for (i = 0; i < v; i++)
		vit[i] += feed[depth][i];

	enough = true;
	for (i = 0; i < v; i++)
		if (vit[i] < req[i])
		{
			enough = false;
			break;
		}
	if (enough)
	{
		count = bitCount(newBin);
		if (count < minCount)
		{
			minCount = count;
			minBin = newBin;
		}
	}
	else
	{
		if (depth < g - 1) search(depth + 1, newBin);
	}

	for (i = 0; i < v; i++)
		vit[i] -= feed[depth][i];

	// not choose
	if (depth < g - 1) search(depth + 1, bin);
}

int main()
{
	int i, j;

	ifstream fin("holstein.in");
	ofstream fout("holstein.out");

	fin >> v;
	for (i = 0; i < v; i++)
		fin >> req[i];
	fin >> g;
	for (i = 0; i < g; i++)
		for (j = 0; j < v; j++)
			fin >> feed[i][j];

	minCount = g + 1;
	search(0, 0);

	fout << minCount;
	for (i = 1; i <= g; i++)
	{
		if (minBin & 1) fout << ' ' << i;
		minBin >>= 1;
	}
	fout << endl;

	return 0;
}
