#include <iostream>
using namespace std;

int main()
{
	int n, i;
	
	cin >> n;
	if (n <= 8)
		cout << 0 << endl;
	else if (n == 9)
		cout << 8 << endl;
	else
	{
		cout << 72;
		for (i = 10; i < n; i++)
			cout << 0;
		cout << endl;
	}

	return 0;
}
