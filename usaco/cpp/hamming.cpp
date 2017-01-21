/*
LANG: C++
PROG: hamming
*/
#include <fstream>
using namespace std;

int bitCount(unsigned int n)
{
	unsigned int c = 0 ;
	for (c = 0; n; c++)
		n &= n - 1;
	return c;
}

int main()
{
	int n, b, d, count, num, i, dis;
	int nums[64];
	bool find;
	
	ifstream fin("hamming.in");
	ofstream fout("hamming.out");
	
	fin >> n >> b >> d;
	
	count = num = 0;
	while (count < n)
	{
		find = true;
		for (i = 0; i < count; i++)
		{
			dis = bitCount(nums[i] ^ num);
			if (dis < d)
			{
				find = false;
				break;
			}
		}
		if (find) nums[count++] = num;
		num++;
	}
	
	for (i = 0; i < n; i++)
	{
		if (i % 10 == 0) fout << nums[i];
		else fout << ' ' << nums[i];
		if (i % 10 == 9 && i != n - 1) fout << endl;
	}
	fout << endl;
	
	return 0;
}