#include <iostream>
#include <cmath>
using namespace std;

int main()
{
	int n, i, ans;
	
	cin >> n;
	ans = n;
	for (i = 2; i <= n; i++)
	{
		if (n % i == 0)
		{
			while (n % i == 0) n = n / i;
			ans = ans * (i - 1) / i;
		}
	}
	cout << ans << endl;
	return 0;
}