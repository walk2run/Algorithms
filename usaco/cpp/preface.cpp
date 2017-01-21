/*
LANG: C++
PROG: preface
*/
#include <fstream>
using namespace std;

int count[100];

void roman(int n)
{
	if (n >= 1000)
	{
		count['M']++;
		roman(n - 1000);
	}
	else if (n >= 900)
	{
		count['C']++;
		count['M']++;
		roman(n - 900);
	}
	else if (n >= 500)
	{
		count['D']++;
		roman(n - 500);
	}
	else if (n >= 400)
	{
		count['C']++;
		count['D']++;
		roman(n - 400);
	}
	else if (n >= 100)
	{
		count['C']++;
		roman(n - 100);
	}
	else if (n >= 90)
	{
		count['X']++;
		count['C']++;
		roman(n - 90);
	}
	else if (n >= 50)
	{
		count['L']++;
		roman(n - 50);
	}
	else if (n >= 40)
	{
		count['X']++;
		count['L']++;
		roman(n - 40);
	}
	else if (n >= 10)
	{
		count['X']++;
		roman(n - 10);
	}
	else if (n >= 9)
	{
		count['I']++;
		count['X']++;
		roman(n - 9);
	}
	else if (n >= 5)
	{
		count['V']++;
		roman(n - 5);
	}
	else if (n >= 4)
	{
		count['I']++;
		count['V']++;
		roman(n - 4);
	}
	else if (n >= 1)
	{
		count['I']++;
		roman(n - 1);
	}		
}

int main()
{
	int n, i;
	char letter[] = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
	
	ifstream fin("preface.in");
	ofstream fout("preface.out");
	
	fin >> n;
	for (i = 1; i <= n; i++)
	{
		roman(i);
	}
	
	for (i = 0; i < 7; i++)
		if (count[letter[i]] > 0)
			fout << letter[i] << ' ' << count[letter[i]] << endl;
	
	return 0;
}