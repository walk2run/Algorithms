/*
LANG: C++
PROG: zerosum
*/
#include <fstream>
using namespace std;

int n;
char ops[10];

ofstream fout("zerosum.out");

void search(int depth, int value, int prev, char op)
{
	int i, newValue;
	
	if (depth == n + 1)
	{
		if (value == 0)
		{
			fout << 1;
			for (i = 2; i <= n; i++)
				fout << ops[i] << i;
			fout << endl;
		}
	}
	else
	{
		newValue = prev * 10 + depth;
		ops[depth] = ' ';
		if (op == '+')
			search(depth + 1, value - prev + newValue, newValue, op);
		else
			search(depth + 1, value + prev - newValue, newValue, op);
		ops[depth] = '+';
		search(depth + 1, value + depth, depth, '+');
		ops[depth] = '-';
		search(depth + 1, value - depth, depth, '-');
	}
}

int main()
{	
	ifstream fin("zerosum.in");
	fin >> n;
	search(2, 1, 1, '+');
	return 0;
}