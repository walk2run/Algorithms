/*
LANG: C++
PROG: ariprog
*/
#include <fstream>
#include <vector>
#include <map>
#include <algorithm>
using namespace std;

void buildBisquares(int m, map<int, bool> &bmap)
{
	int p, q;
	for (p = 0; p <= m; p++)
		for (q = 0; q <= m; q++)
			bmap.insert(pair<int, bool>(p*p + q*q, 1));
}

bool exist(int n, int a, int b, map<int, bool> &bmap)
{
	int i;
	for (i = 2; i < n; i++)
		if (bmap.count(a + i * b) == 0) return false;
	return true;
}

struct Pair
{
	int a, b;
	Pair(int a, int b) : a(a), b(b) {}
};

bool cmp(const Pair &a, const Pair &b)
{
	if (a.b == b.b)
		return a.a < b.a;
	else
		return a.b < b.b;
}

int main()
{
	int n, m, a, b;
	map<int, bool> bmap;
	map<int, bool>::iterator i, j;
	bool find;
	vector<Pair> answers;

	ifstream fin("ariprog.in");
	ofstream fout("ariprog.out");
	
	fin >> n >> m;

	buildBisquares(m, bmap);

	find = false;
	for (i = bmap.begin(); i != --bmap.end(); i++)
	{
		for (j = i, j++; j != bmap.end(); j++)
		{
			a = i->first;
			b = j->first - i->first;
			if (a + (n - 1) * b > 2 * m * m) break;
			if (exist(n, a, b, bmap))
			{
				find = true;
				answers.push_back(Pair(a, b));
			}
		}
	}
	
	if (find)
	{
		sort(answers.begin(), answers.end(), cmp);
		for (int i = 0; i < answers.size(); i++)
			fout << answers[i].a << ' ' << answers[i].b << endl;
	}
	else
	{
		fout << "NONE\n";
	}

	return 0;
}