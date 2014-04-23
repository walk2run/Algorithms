#include <iostream>
using namespace std;

typedef unsigned uint;

uint gcd(uint a, uint b)
{
	uint r;
	while (b > 0)
	{
		r = a % b;
		a = b;
		b = r;
	}
	return a;
}

int main()
{
	uint a, b, count, d;
	
	cin >> a >> b;
	
	count = 0;
	while (1)
	{
		if (!a || !b)
		{
			cout << count << endl;
			break;
		}
		if ((a + b) % 2)
		{
			cout << "-1\n";
			break;
		}
		//cout << a << ' ' << b << endl;
		d = gcd(a, b);
		a /= d;
		b /= d;
		//cout << a << ' ' << b << "\n\n";
		if (a < b)
		{
			a = a ^ b;
			b = a ^ b;
			a = a ^ b;
		}
		a -= b;
		b += b;
		count++;
	}
	
	return 0;
}