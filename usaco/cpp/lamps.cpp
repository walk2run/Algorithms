/*
LANG: C++
PROG: lamps
*/
#include <fstream>
#include <cstring>
#include <vector>
#include <algorithm>
using namespace std;

int main()
{
	int n, c, id, i, binCount, offset, quo, j, ii;
	unsigned lamps, bin;
	bool ons[7], offs[7], find;
	vector<unsigned> ans;
	
	ifstream fin("lamps.in");
	ofstream fout("lamps.out");
	
	fin >> n >> c;
	offset = n % 6;
	quo = n / 6;
	memset(ons, 0, sizeof(bool) * 7);
	fin >> id;
	while (id != -1)
	{
		id %= 6;
		if (id == 0) id = 6;
		ons[id] = true;
		fin >> id;
	}
	fin >> id;
	memset(offs, 0, sizeof(bool) * 7);
	while (id != -1)
	{
		id %= 6;
		if (id == 0) id = 6;
		offs[id] = true;
		fin >> id;
	}
	
	for (bin = 0; bin < 16; bin++)
	{
		lamps = 0x3f;
		binCount = 0;
		if (bin & 8)
		{
			lamps ^= 0x3f;
			binCount++;
		}
		if (bin & 4)
		{
			lamps ^= 0x2a;
			binCount++;
		}
		if (bin & 2)
		{
			lamps ^= 0x15;
			binCount++;
		}
		if (bin & 1)
		{
			lamps ^= 0x24;
			binCount++;
		}
		//fout << lamps << endl;
		
		if (c >= binCount && (c - binCount) % 2 == 0)
		{
			find = true;
			for (i = 1; i <= 6; i++)
				if (ons[i] && !(lamps & (1 << 6 >> i)) || offs[i] && (lamps & (1 << 6 >> i)))
				{
					find = false;
					break;
				}
			if (find)
			{
				lamps = (lamps << offset) | (lamps >> (6 - offset));
				ans.push_back(lamps);
			}
		}
	}
	
	sort(ans.begin(), ans.end());
	for (i = 0; i < ans.size(); i++)
	{
		for (ii = 1; ii <= quo; ii++)
			for (j = 1; j <= 6; j++)
				if (ans[i] & (1 << (6 + offset) >> j))
					fout << 1;
				else
					fout << 0;
		for (j = 1; j <= offset; j++)
			if (ans[i] & (1 << offset >> j))
				fout << 1;
			else
				fout << 0;
		fout << endl;
	}
	if (ans.empty()) fout << "IMPOSSIBLE\n";
	
	return 0;
}