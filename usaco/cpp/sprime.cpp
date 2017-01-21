/*
LANG: C++
PROG: sprime
*/
#include <fstream>
#include <cmath>
using namespace std;

bool prime(int nums[], int width)
{
	int i, n, ten, max;

	n = 0;
	ten = 1;
	for (i = width; i > 0; i--)
	{
		n += nums[i] * ten;
		ten *= 10;
	}
	
	max = sqrt(double(n));
	for (i = 2; i <= max; i++)
		if (n % i == 0) return false;
	return true;
}

ofstream fout("sprime.out");

void print(int nums[], int n)
{
	for (int i = 1; i <= n; i++)
		fout << nums[i];
	fout << endl;
}

void search(int depth, int n, int nums[])
{
	static int nums1[] = {2, 3, 5, 7};
	static int numsN[] = {1, 3, 7, 9};
	int i;

	if (depth == 1)
		for (i = 0; i < 4; i++)
		{
			nums[depth] = nums1[i];
			search(depth + 1, n, nums);
		}
	else if (depth == n)
		for (i = 0; i < 4; i++)
		{
			nums[depth] = numsN[i];
			if (prime(nums, n)) print(nums, n);
		}
	else
		for (i = 0; i <= 9; i++)
		{
			nums[depth] = i;
			if (prime(nums, depth)) search(depth + 1, n, nums);
		}
}

int main()
{
	int n, nums[9];

	ifstream fin("sprime.in");

	fin >> n;

	search(1, n, nums);

	return 0;
}