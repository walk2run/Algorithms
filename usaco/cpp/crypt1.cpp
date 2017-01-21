/*
LANG: C++
PROG: crypt1
*/
#include <fstream>
using namespace std;

bool validate(int num, int digits[], int n)
{
	int remain, i;
	bool find;
	if (num / 1000 >= 1) return false;
	while (num > 0)
	{
		remain = num % 10;
		num = num / 10;
		find = false;
		for (i = 0; i < n; i++)
			if (remain == digits[i]) find = true;
		if (!find) return false;
	}
	return true;
}

bool validate4(int num, int digits[], int n)
{
	int remain, i;
	bool find;
	if (num / 10000 >= 1) return false;
	while (num > 0)
	{
		remain = num % 10;
		num = num / 10;
		find = false;
		for (i = 0; i < n; i++)
			if (remain == digits[i]) find = true;
		if (!find) return false;
	}
	return true;
}

int main()
{
	int n, i, i1, i2, i3, j1, j2, num1, product1, product2, count;
	int digits[9];

	ifstream fin("crypt1.in");
	ofstream fout("crypt1.out");

	fin >> n;
	for (i = 0; i < n; i++)
		fin >> digits[i];

	count = 0;
	for (i1 = 0; i1 < n; i1++)
		for (i2 = 0; i2 < n; i2++)
			for (i3 = 0; i3 < n; i3++)
			{
				num1 = digits[i1] * 100 + digits[i2] * 10 + digits[i3];
				for (j1 = 0; j1 < n; j1++)
				{
					product2 = num1 * digits[j1];
					if (!validate(product2, digits, n)) continue;
					for (j2 = 0; j2 <n; j2++)
					{
						product1 = num1 * digits[j2];
						if (!validate(product1, digits, n)) continue;
						if (!validate4(product2 * 10 + product1, digits, n)) continue;
						count ++;
					}
				}
			}

	fout << count << endl;
	return 0;
}