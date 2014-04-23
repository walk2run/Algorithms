#include <iostream>
#include <math.h>
using namespace std;

bool prime(unsigned a, unsigned start)
{
	for (unsigned i = start; i <= sqrt(a); i++)
		if (a % i == 0) return false;
	return true;
}

void solve()
{
	unsigned a, i, q;
	
	cin >> a;
	for (i = 2; i <= sqrt(a); i++)
	{
		if (a % i == 0)
		{
			if (prime(a / i, i))
			{
				cout << "Yes\n";
				return;
			}
			else
			{
				cout << "No\n";
				return;
			}
		}
	}
	cout << "No\n";
}

int main()
{
	unsigned n, i;
	
	cin >> n;
	for (i = 0; i < n; i++)
		solve();
}