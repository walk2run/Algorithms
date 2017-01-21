/*
LANG: C++
TASK: beads
*/
#include <fstream>
#include <string>
using namespace std;

int forward(const string & str, int n, int p)
{
	char now, next;
	int count;
	
	now = str[p];
	count = 1;
	while (count < n)
	{
		p = (p + 1) % n;
		next = str[p];
		if (now == 'w')
		{
			count++;
			now = next;
		}
		else if (next == 'w' || now == next)
			count++;
		else 
			break;
	}
	return count;
}

int back(const string & str, int n, int p)
{
	char now, next;
	int count;
	
	p--;
	if (p == -1) p = n - 1;
	now = str[p];
	count = 1;
	while (count < n)
	{
		p--;
		if (p == -1) p = n - 1;
		next = str[p];
		if (now == 'w')
		{
			count++;
			now = next;
		}
		else if (next == 'w' || now == next)
			count++;
		else
			break;
	}
	return count;		
}

int main()
{
	int n, i, count, maxCount;
	string str;
	
	ifstream fin("beads.in");
	ofstream fout("beads.out");
	fin >> n >> str;

	maxCount = 0;
	for (i = 0; i < n; i++)
	{
		count = forward(str, n, i) + back(str, n, i);
		if (count >= n)
		{
			maxCount = n;
			break;
		}
		if (count > maxCount) maxCount = count;
	}
	
	fout << maxCount << endl;
	return 0;
}