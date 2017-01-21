/*
LANG: C++
PROG: subset
*/
#include <fstream>
using namespace std;

long long d[40];

int main()
{
	int n, i, j, sum;
	
	ifstream fin("subset.in");
	ofstream fout("subset.out");
	
	fin >> n;
	
	d[0] = 1;
	sum = n * (n + 1) / 2;
	if (sum % 2)
	{
		fout << "0\n";
		return 0;
	}
	
	sum /= 2;
	for (i = 1; i <= n; i++)
		for (j = sum; j >= i; j--)
			d[j] += d[j-i];
	fout << d[sum] / 2 << endl;
	
	return 0;
}
