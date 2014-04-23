#include <iostream>
using namespace std;

int main()
{
	int days[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	int month, day, i, sum;
	
	cin >> day >> month;
	if (month < 1 || month > 12)
		cout << "Impossible\n";
	else if (day < 1 || day > days[month])
		cout << "Impossible\n";
	else
	{
		sum = 0;
		for (i = 1; i < month; i++)
			sum += days[i];
		sum = (sum + day) % 7;
		if (sum == 0) sum = 7;
		cout << sum << endl;
	}
	return 0;
}