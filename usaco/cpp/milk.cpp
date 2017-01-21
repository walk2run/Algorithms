/*
LANG: C++
PROG: milk
*/
#include <fstream>
#include <queue>
using namespace std;

struct Farmer
{
	int price, amount;
};

struct cmp
{
	bool operator()(const Farmer &a, const Farmer &b)
	{
		return a.price > b.price;
	}
};

int main()
{
	int n, m, i, price;
	Farmer farmer;
	priority_queue<Farmer, vector<Farmer>, cmp> heap;

	ifstream fin("milk.in");
	ofstream fout("milk.out");
	fin >> n >> m;
	for (i = 0; i < m; i++)
	{
		fin >> farmer.price >> farmer.amount;
		heap.push(farmer);
	}

	price = 0;
	while (n > 0)
	{
		farmer = heap.top();
		heap.pop();
		if (farmer.amount < n)
		{
			price += farmer.price * farmer.amount;
			n -= farmer.amount;
		}
		else
		{
			price += farmer.price * n;
			n = 0;
		}
	}

	fout << price << '\n';

	return 0;
}