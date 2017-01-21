/*
LANG: C++
TASK: ride
*/
#include <iostream>
#include <fstream>
#include <string>
using namespace std;

int f(const string & st)
{
	int p = 1;
	for (int i = 0; i < st.size(); i++)
		p *= st[i]-'A'+1;
	return p % 47;
}

int main()
{
	string a, b;
	ifstream fin("ride.in");
	ofstream fout("ride.out");
	fin >> a >> b;
	if (f(a) == f(b))
		fout << "GO\n";
	else
		fout << "STAY\n";
	return 0;
}