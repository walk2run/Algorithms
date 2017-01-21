/*
LANG: C++
PROG: palsquare
*/
#include <fstream>
#include <string>
using namespace std;

void transform(int base, int n, string &st)
{
	int remainder;
	st = "";
	while (n)
	{
		remainder = n % base;
		n /= base;
		if (remainder < 10)
			st = char('0' + remainder) + st;
		else
			st = char('A' + remainder - 10) + st;
	}
}

bool palindrome(const string &st)
{
	for (int i = 0; i < st.size() / 2; i++)
		if (st[i] != st[st.size()-1-i]) return false;
	return true;
}

int main()
{
	int base, n, n2;
	string st, st2;

	ifstream fin("palsquare.in");
	ofstream fout("palsquare.out");
	fin >> base;

	for (n = 1; n <= 300; n++)
	{
		n2 = n * n;
		transform(base, n2, st2);
		if (palindrome(st2))
		{
			transform(base, n, st);
			fout << st << ' ' << st2 << '\n';
		}
	}

	return 0;
}
