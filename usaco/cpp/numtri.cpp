/*
LANG: C++
PROG: numtri
*/
#include <fstream>
#include <vector>
using namespace std;

int main()
{
	int r, i, j;

	ifstream fin("numtri.in");
	ofstream fout("numtri.out");

	fin >> r;
	vector<vector<int> > tri(r), d(r);

	for (i = 0; i < r; i++)
	{
		tri[i].resize(i+1);
		d[i].resize(i+1);
		for (j = 0; j <= i; j++)
			fin >> tri[i][j];
	}

	for (j = 0; j < r; j++)
		d[r-1][j] = tri[r-1][j];
	for (i = r - 2; i >= 0; i--)
		for (j = 0; j <= i; j++)
			d[i][j] = max(d[i+1][j], d[i+1][j+1]) + tri[i][j];

	fout << d[0][0] << endl;

	return 0;
}