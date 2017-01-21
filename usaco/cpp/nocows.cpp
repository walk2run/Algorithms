/*
LANG: C++
PROG: nocows
*/
#include <fstream>
using namespace std;

const int MOD = 9901;

int main()
{
	int n, h, i, j, u;
	int d[200][100];
	
	ifstream fin("nocows.in");
	ofstream fout("nocows.out");
	
	fin >> n >> h;
	
	for (j = 1; j <= h; j++)
		d[1][j] = 1;
	for (i = 2; i <= n; i++)
		for (j = 1; j <= h; j++)
		{
			d[i][j] = 0;
			for (u = 1; u <= i - 1; u++)
			{
				d[i][j] += d[u][j-1] * d[i-u-1][j-1];
				d[i][j] %= MOD;
			}
		}
	
	fout << (d[n][h] - d[n][h-1] + MOD) % MOD << endl;
	
	return 0;
}