/*
LANG: C++
PROG: pprime
*/
#include <fstream>
#include <cmath>
#include <map>
using namespace std;

map<int, bool> pmap;

int mirror(int half, int width)
{
	int i, quotient, digit;
	quotient = half;
	for (i = 0; i < width - 1; i++)
	{
		digit = quotient % 10;
		quotient /= 10;
		half += digit * pow(10.0, (width - 1) * 2 - i);
	}
	return half;
}

bool prime(int n)
{
	int i, max;
	max = sqrt(double(n));
	for (i = 2; i <= max; i++)
		if (n % i == 0) return false;
	return true;
}

void palindrome(int width, int a, int b, ofstream &fout)
{
	int half, max, n;
	
	max = pow(10.0, width);
	half = 1;
	while (half < max)
	{
		n = mirror(half, width);
		if (prime(n) && n >= a && n <= b) pmap.insert(pair<int, bool>(n, 1));
		half += 2;
	}
}

int main()
{
	int a, b;
	map<int, bool>::iterator it;

	ifstream fin("pprime.in");
	ofstream fout("pprime.out");

	fin >> a >> b;

	palindrome(1, a, b, fout);
	if (11 >= a && 11 <= b) pmap.insert(pair<int, bool>(11, 1));
	palindrome(2, a, b, fout);
	palindrome(3, a, b, fout);
	palindrome(4, a, b, fout);

	for (it = pmap.begin(); it != pmap.end(); it++)
		fout << it->first << endl;
	
	return 0;
}