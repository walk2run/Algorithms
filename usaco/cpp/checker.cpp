/*
LANG: C++
PROG: checker
*/
#include <fstream>
using namespace std;

int n, board[13], count;
bool used[13];
ofstream fout("checker.out");

void search(int row, int left, int right)
{
	int i;
	unsigned bits;
	if (row == n)
	{
		count ++;
		if (count <= 3)
		{
			fout << board[0]+1;
			for (i = 1; i < n; i++)
				fout << ' ' << board[i]+1;
			fout << endl;
		}
	}
	else
	{
		bits = left | right;
		for (i = 0; i < n; i++)
			if (!used[i] && !(bits & 1 << i))
			{
				used[i] = true;
				board[row] = i;
				search(row+1, (left | 1 << i) >> 1, (right | 1 << i) << 1);
				used[i] = false;
			}
	}
}

int main()
{
	ifstream fin("checker.in");
	fin >> n;
	search(0, 0, 0);
	fout << count << endl;
	return 0;
}