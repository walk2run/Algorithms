#include <iostream>
using namespace std;

// a ^ b % m
int calmod(int a, int b, int m)
{
	int r, ans;
	
	r = a % m;
	ans = 1;
	while (b)
	{
		if (b & 1) ans = (ans * r) % m;
		r = (r * r) % m;
		b >>= 1;
	}
	return ans;
}

int main()
{
	int n, m, k, num, i, count;
	
	cin >> n >> m >> k;
	count = 0;
	for (i = 0; i < n; i++)
	{
		cin >> num;
		if (calmod(num, m, k) == 0)	count++;
	}
	cout << count << endl;
	
	return 0;
}