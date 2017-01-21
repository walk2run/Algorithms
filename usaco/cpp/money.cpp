/*
LANG: C++
PROG: money
*/
#include <fstream>
using namespace std;

long long d[10001];

int main()
{
	int v, n, i, j, value;
	
	ifstream fin("money.in");
	ofstream fout("money.out");
	
	fin >> v >> n;
	d[0] = 1;
	for (i = 0; i < v; i++)
	{
		fin >> value;
		for (j = value; j <= n; j++)
			d[j] += d[j-value];
	}
	
	fout << d[n] << endl;
	
	return 0;
}