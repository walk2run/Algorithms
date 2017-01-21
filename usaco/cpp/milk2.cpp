/*
LANG: C++
PROG: milk2
*/
#include <fstream>
#include <vector>
#include <list>
#include <algorithm>

struct Range
{
	int start, end;
};

bool cmp(const Range &a, const Range &b)
{
	return a.start < b.start;
}

int main()
{
	int n, i, maxMilk, maxIdle, len, end;
	Range range;
	std::vector<Range> vector;
	std::list<Range> list;
	std::list<Range>::iterator it;
	
	std::ifstream fin("milk2.in");
	std::ofstream fout("milk2.out");
	
	fin >> n;
	for (i = 0; i < n; i++)
	{
		fin >> range.start >> range.end;
		vector.push_back(range);
	}
	std::sort(vector.begin(), vector.end(), cmp);

	list.push_back(vector[0]);
	for (i = 1; i < n; i++)
	{
		it = --list.end();
		range = vector[i];
		if (range.start <= it->end)
		{
			if (range.end > it->end)
				it->end = range.end;
		}
		else
			list.push_back(range);
	}

	maxMilk = 0;
	maxIdle = 0;
	it = list.begin();
	end = it->end;
	for (; it != list.end(); it++)
	{
		len = it->end - it->start;
		if (len > maxMilk) maxMilk = len;
		len = it->start - end;
		if (len > maxIdle) maxIdle = len;
		end = it->end;
	}

	fout << maxMilk << ' ' << maxIdle << '\n';

	return 0;
}