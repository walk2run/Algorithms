#include <iostream>
using namespace std;

int counts[10];

int main()
{
	int k, n, i, phone, page;
	
	cin >> k >> n;
	for (i = 0; i < n; i++)
	{
		cin >> phone;
		phone /= 1000;
		counts[phone]++;
	}
	
	page = 2;
	for (i = 1; i <= 9; i++)
	{
		if (counts[i] > 0)
			page += (counts[i] - 1) / k + 1;
	}
	
	cout << page << endl;
	
	return 0;
}