/*
LANG: C++
PROG: frac1
*/
#include <fstream>
using namespace std;

int n;
ofstream fout("frac1.out");

// a/b, c/d
void search(int a, int b, int c, int d)
{
	int e, f;
	e = a + c;
	f = b + d;
	if (f < n) search(a, b, e, f);
	if (f <= n) fout << e << '/' << f << endl;
	if (f < n) search(e, f, c, d);
}

int main()
{
	ifstream fin("frac1.in");
	fin >> n;
	fout << "0/1\n";
	search(0, 1, 1, 1);
	fout << "1/1\n";
	return 0;
}