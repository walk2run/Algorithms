/*
LANG: C++
PROG: milk3
*/
#include <fstream>
#include <vector>
#include <algorithm>
using namespace std;

int A, B, C;
bool exist[21][21][21];
vector<int>	ans;

// a->b
void pour(int &a, int &b, int B)
{
	if (a + b <= B)
	{
		b = a + b;
		a = 0;
	}
	else
	{
		a = a - (B - b);
		b = B;
	}
}

void search(int a, int b, int c)
{
	int aa, bb, cc;
	if (!exist[a][b][c])
	{
		exist[a][b][c] = 1;
		if (a == 0) ans.push_back(c);

		aa = a; bb = b; cc = c;
		pour(aa, bb, B);
		search(aa, bb, cc);

		aa = a; bb = b; cc = c;
		pour(aa, cc, C);
		search(aa, bb, cc);

		aa = a; bb = b; cc = c;
		pour(bb, aa, A);
		search(aa, bb, cc);

		aa = a; bb = b; cc = c;
		pour(bb, cc, C);
		search(aa, bb, cc);

		aa = a; bb = b; cc = c;
		pour(cc, aa, A);
		search(aa, bb, cc);

		aa = a; bb = b; cc = c;
		pour(cc, bb, B);
		search(aa, bb, cc);
	}
}

int main()
{
	ifstream fin("milk3.in");
	ofstream fout("milk3.out");

	fin >> A >> B >> C;

	search(0, 0, C);

	sort(ans.begin(), ans.end());

	fout << ans[0];
	for (int i = 1; i < ans.size(); i++)
		fout << ' ' << ans[i];
	fout << endl;

	return 0;
}