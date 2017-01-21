/*
LANG: C++
PROG: namenum
*/
#include <fstream>
#include <string>

char letter2num(char ch)
{
	if (ch >= 'A' && ch <= 'C') return '2';
	if (ch >= 'D' && ch <= 'F') return '3';
	if (ch >= 'G' && ch <= 'I') return '4';
	if (ch >= 'J' && ch <= 'L') return '5';
	if (ch >= 'M' && ch <= 'O') return '6';
	if (ch >= 'P' && ch <= 'S') return '7';
	if (ch >= 'T' && ch <= 'V') return '8';
	if (ch >= 'W' && ch <= 'Y') return '9';
	return ' ';
}

int main()
{
	std::string num, num2, word;
	int i;
	char ch;
	bool none;

	std::ifstream fin("namenum.in");
	std::ofstream fout("namenum.out");
	std::ifstream fdict("dict.txt");

	fin >> num;
	none = true;
	while (fdict >> word)
	{
		if (num.size() == word.size())
		{
			num2 = "";
			for (i = 0; i < word.size(); i++)
			{
				ch = letter2num(word[i]);
				num2 += ch;
			}
			if (num == num2)
			{
				fout << word << '\n';
				none = false;
			}
		}
	}
	if (none) fout << "NONE\n";

	return 0;
}