#include <iostream>
using namespace std;

int main()
{
	unsigned n;
	unsigned f[] = {0, 0, 1};
	cin >> n;
	
	cout << n / 3 * 2 + f[n % 3] << endl;
	
	return 0;
}