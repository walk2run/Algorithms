/*
LANG: C++
PROG: runround
*/
#include <fstream>
#include <stdio.h>
#include <string.h>
using namespace std;

int main()
{
	unsigned long long m;
	int len, i;
	char st[30];
	bool use[10], legal;
	
	ifstream fin("runround.in");
	ofstream fout("runround.out");
	
	fin >> m;
	while (1)
	{
		sprintf(st, "%u", ++m);
		len = strlen(st);
		for (i = 0; i <= 9; i++)
			use[i] = false;
		legal = true;
		for (i = 0; i < len; i++)
		{
			st[i] -= '0';
			if (use[st[i]] || st[i] == 0)
			{
				legal = false;
				break;
			}
			use[st[i]] = true;
		}
		if (!legal) continue;
		
		for (i = 0; i <= 9; i++)
			use[i] = false;
		i = 0;
		use[0] = true;
		while (1)
		{
			i = (i + st[i]) % len;
			if (i == 0 || use[i]) break;
			use[i] = true;
		}
		if (i == 0)
		{
			for (i = 0; i < len; i++)
				if (!use[i])
				{
					legal = false;
					break;
				}
			if (legal)
			{
				fout << m << endl;
				break;
			}
		}
	}
	
	return 0;
}