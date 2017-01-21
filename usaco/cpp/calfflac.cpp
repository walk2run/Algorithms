/*
LANG: C++
PROG: calfflac
*/
#include <fstream>
#include <string>
using namespace std;

int	 prev(int p, const string &st)
{
	while (p > 0)
		if (isalpha(st[--p])) return p;
	return -1;
}

int next(int p, const string &st)
{
	while (p < st.size() - 1)
		if (isalpha(st[++p])) return p;
	return -1;
}

int main()
{
	char ch;
	int i, p1, p2, newP1, newP2, len, maxLen, maxP1, maxP2;
	string st;

	ifstream fin("calfflac.in");
	ofstream fout("calfflac.out");
	
	fin.unsetf(ios::skipws);
	while (fin >> ch)
		st.push_back(ch);

	maxLen = 0;
	for (i = 0; i < st.size(); i++)
	{
		if (isalpha(st[i]))
		{
			p1 = p2 = i;
			len = 1;
			while (1)
			{
				newP1 = prev(p1, st);
				newP2 = next(p2, st);
				if (newP1 < 0 || newP2 < 0) break;
				if (tolower(st[newP1]) != tolower(st[newP2])) break;
				p1 = newP1;
				p2 = newP2;
				len += 2;
			}
			if (len > maxLen)
			{
				maxLen = len;
				maxP1 = p1;
				maxP2 = p2;
			}

			p1 = i;
			p2 = next(i, st);
			if (p2 < 0) continue;
			if (tolower(st[p1]) != tolower(st[p2])) continue;
			len = 2;
			while (1)
			{
				newP1 = prev(p1, st);
				newP2 = next(p2, st);
				if (newP1 < 0 || newP2 < 0) break;
				if (tolower(st[newP1]) != tolower(st[newP2])) break;
				p1 = newP1;
				p2 = newP2;
				len += 2;
			}
			if (len > maxLen)
			{
				maxLen = len;
				maxP1 = p1;
				maxP2 = p2;
			}
		}
	}

	fout << maxLen << endl;
	for (i = maxP1; i <= maxP2; i++)
		fout << st[i];
	fout << endl;

	return 0;
}