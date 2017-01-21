/*
LANG: C++
PROG: prefix
*/
#include <fstream>
#include <vector>
#include <string>
using namespace std;

int main()
{
	vector<string> primitives;
	string st, seq;
	int i, j, size;
	bool d[200001];	// first is 1
	
	ifstream fin("prefix.in");
	ofstream fout("prefix.out");
	
	fin >> st;
	while (st != ".")
	{
		primitives.push_back(st);
		fin >> st;
	}
	seq = "";
	while (fin >> st)
		seq += st;
	
	d[0] = true;
	for (i = 1; i <= seq.size(); i++)
	{
		d[i] = false;
		for (j = 0; j < primitives.size(); j++)
		{
			size = primitives[j].size();
			if (size <= i)
				if (d[i-size] && seq.substr(i - size, size) == primitives[j])
						d[i] = true;
		}
	}
	
	for (i = seq.size(); i >= 0 && !d[i]; i--) ;
	
	fout << i << endl;
	
	return 0;
}