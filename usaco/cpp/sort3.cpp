/*
LANG: C++
PROG: sort3
*/
#include <fstream>
using namespace std;

int main()
{
	int n, i, x, sum;
	int v[1000], count[4], a[4], b[4], c[4];

	for (i = 0; i < 4; i++)
		count[i] = a[i] = b[i] = c[i] = 0;

	ifstream fin("sort3.in");
	ofstream fout("sort3.out");

	fin >> n;
	for (i = 0; i < n; i++)
	{
		fin >> v[i];
		count[v[i]]++;
	}

	for (i = 0; i < n; i++)
	{
		if (i < count[1]) a[v[i]]++;
		else if (i < count[1] + count[2]) b[v[i]]++;
		else c[v[i]]++;
	}

	sum = min(a[2], b[1]);
	a[2] -= sum;
	b[1] -= sum;

	x = min(a[3], c[1]);
	sum += x;
	a[3] -= x;
	c[1] -= x;

	x = min(b[3], c[2]);
	sum += x;
	b[3] -= x;
	c[2] -= x;

	sum += (a[2] + a[3] + b[1] + b[3] + c[1] + c[2]) * 2 / 3;
	
	fout << sum << endl;

	return 0;
}