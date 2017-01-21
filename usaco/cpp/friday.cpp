/*
LANG: C++
TASK: friday
*/
#include <fstream>
using namespace std;

int daysOfMonth[13] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

/*
 * 13th Jan falls on day
 * Return day on which 13th Jan in next year falls
 */
int dealYear(int *list, int year, int day)
{
	bool leap = !(year % 400) || (!(year % 4) && (year % 100));
	if (leap) daysOfMonth[2] = 29;
	for (int i = 1; i <= 12; i++)
	{
		list[day]++;
		day = (day + daysOfMonth[i]) % 7;
	}

	daysOfMonth[2] = 28;
	return day;
}

int main()
{
	int n, i, year, day;
	int list[7];

	for (i = 0; i < 7; i++) list[i] = 0;

	ifstream fin("friday.in");
	ofstream fout("friday.out");
	fin >> n;

	year = 1900;
	day = 6;
	for (i = 0; i < n; i++)
	{
		day = dealYear(list, year, day);
		year++;
	}

	fout << list[6];
	for (i = 0; i <= 5; i++)
		fout << ' ' << list[i];
	fout << endl;

	return 0;
}