/*
LANG: C++
TASK: gift1
*/
#include <iostream>
#include <fstream>
#include <string>
using namespace std;

struct Person
{
	string name;
	int money;
};

int find(const string & name, const Person * list, int np)
{
	for (int i = 0; i < np; i++)
		if (name == list[i].name) return i;
	return -1;
}

int main()
{
	int np, i, j, money, num, sender, receiver, give, left;
	string name;
	Person list[10];
	
	ifstream fin("gift1.in");
	ofstream fout("gift1.out");
	fin >> np;
	for (i = 0; i < np; i++)
	{
		fin >> list[i].name;
		list[i].money = 0;
	}
	for (i = 0; i < np; i++)
	{
		fin >> name;
		sender = find(name, list, np);
		fin >> money >> num;
		if (num == 0) continue;
		give = money / num;
		left = money % num;
		list[sender].money -= money - left;
		for (j = 0; j < num; j++)
		{
			fin >> name;
			receiver = find(name, list, np);
			list[receiver].money += give;
		}
	}
	for (i = 0; i < np; i++)
		fout << list[i].name << ' ' << list[i].money << endl;
	return 0;
}