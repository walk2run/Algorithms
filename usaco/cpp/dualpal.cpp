/*
LANG: C++
PROG: dualpal
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
	int n, s, i, nCount, palCount;
	string st;

	ifstream fin("dualpal.in");
	ofstream fout("dualpal.out");
	fin >> n >> s;

	nCount = 0;
	while (nCount < n)
	{
		s++;
		palCount = 0;
		for (i = 2; i <= 10; i++)
		{
			transform(i, s, st);
			if (palindrome(st))
			{
				palCount++;
				if (palCount == 2)
				{
					fout << s << '\n';
					nCount++;
					break;
				}
			}
		}
	}

	return 0;
}