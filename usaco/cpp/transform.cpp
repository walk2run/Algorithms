/*
LANG: C++
PROG: transform
*/
#include <fstream>

bool equal(int n, char a[][11], char b[][11])
{
	int i, j;
	for (i = 0; i < n; i++)
		for (j = 0; j < n; j++)
			if (a[i][j] != b[i][j]) return false;
	return true;
}

int transform(int n, char a[][11], char b[][11])
{
	int i, j;
	char tmp[11][11];


	for (i = 0; i < n; i++)
		for (j = 0; j < n; j++)
			tmp[j][n-1-i] = a[i][j];
	if (equal(n, tmp, b)) return 1;
	
	for (i = 0; i < n; i++)
		for (j = 0; j < n; j++)
			tmp[n-1-i][n-1-j] = a[i][j];
	if (equal(n, tmp, b)) return 2;

	for (i = 0; i < n; i++)
		for (j = 0; j < n; j++)
			tmp[n-1-j][i] = a[i][j];
	if (equal(n, tmp, b)) return 3;

	for (i = 0; i < n; i++)
		for (j = 0; j < n; j++)
			tmp[i][n-1-j] = a[i][j];
	if (equal(n, tmp, b)) return 4;

	for (i = 0; i < n; i++)
		for (j = 0; j < n; j++)
			tmp[n-1-j][n-1-i] = a[i][j];
	if (equal(n, tmp, b)) return 5;

	for (i = 0; i < n; i++)
		for (j = 0; j < n; j++)
			tmp[n-1-i][j] = a[i][j];
	if (equal(n, tmp, b)) return 5;

	for (i = 0; i < n; i++)
		for (j = 0; j < n; j++)
			tmp[j][i] = a[i][j];
	if (equal(n, tmp, b)) return 5;

	if (equal(n, a, b)) return 6;

	return 7;
}

int main()
{
	int n, i;
	char a[11][11], b[11][11];

	std::ifstream fin("transform.in");
	std::ofstream fout("transform.out");

	fin >> n;
	for (i = 0; i < n; i++)	fin >> a[i];
	for (i = 0; i < n; i++) fin >> b[i];

	fout << transform(n, a, b) << '\n';

	return 0;
}