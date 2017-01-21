/*
LANG: C++
PROG: barn1
*/
#include <fstream>
#include <queue>
#include <algorithm>
using namespace std;

int main()
{
	int m, s, c, i, num, len;
	vector<int> vect;
	priority_queue<int> heap;

	ifstream fin("barn1.in");
	ofstream fout("barn1.out");

	fin >> m >> s >> c;
	for (i = 0; i < c; i++)
	{
		fin >> num;
		vect.push_back(num);
	}

	sort(vect.begin(), vect.end());

	for (i = 1; i < c; i++)
		heap.push(vect[i] - vect[i-1] - 1);
	
	len = vect.back() - vect[0] + 1;
	for (i = 1; i < m; i++)
	{
		if (heap.size() == 0) break;
		len -= heap.top();
		heap.pop();
	}

	fout << len << '\n';
	
	return 0;
}