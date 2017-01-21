/*
LANG: C++
PROG: clocks
*/
#include <fstream>
#include <list>
#include <vector>
#include <string>
using namespace std;

struct Clocks
{
	int *c, moveType, sameMoves;
	Clocks *prev;

	void alloc()
	{
		c = new int[9];
	}

	void free()
	{
		delete c;
	}
};

typedef list<Clocks> ClocksList;

void move(int moveType, Clocks &oldClocks, Clocks &newClocks)
{
	static string moveStr[10] = {"", "ABDE", "ABC", "BCEF", "ADG", "BDEFH", "CFI", "DEGH", "GHI", "EFHI"};
	int i, whichClock;

	if (oldClocks.moveType == moveType)
		newClocks.sameMoves = oldClocks.sameMoves + 1;
	else
		newClocks.sameMoves = 1;
	newClocks.moveType = moveType;
	newClocks.prev = &oldClocks;
	string str = moveStr[moveType];
	for (i = 0; i < 9; i++)
		newClocks.c[i] = oldClocks.c[i];
	for (i = 0; i < str.size(); i++)
	{
		whichClock = str[i]-'A';
		newClocks.c[whichClock] += 3;
		if (newClocks.c[whichClock] > 12) newClocks.c[whichClock] = 3;
	}
}

bool equals(const Clocks &a, const Clocks &b)
{
	for (int i = 0; i < 9; i++)
		if (a.c[i] != b.c[i]) return false;
	return true;
}

/* Return 1 on finding a solution, 0 if not */
int add(const Clocks &clocks, ClocksList &cList)
{
	ClocksList::iterator it;
	bool find = true;

	for (int i = 0; i < 9; i++)
		if (clocks.c[i] != 12)
		{
			find = false;
			break;
		}
	if (find) return 1;
	//for (it = cList.begin(); it != cList.end(); it++)
	//	if (equals(clocks, *it)) return 0;
	cList.push_back(clocks);
	return 0;
}

void print(ofstream &fout, Clocks *clocks)
{
	vector<int> moves;
	int i;

	while (clocks->prev)
	{
		moves.push_back(clocks->moveType);
		clocks = clocks->prev;
	}

	fout << *(moves.end()-1);
	for (i = moves.size() - 2; i >= 0; i--)
		fout << ' ' << moves[i];
	fout << endl;
}

int main()
{
	int i, find;
	Clocks clocks;
	ClocksList cList;
	ClocksList::iterator iter;

	ifstream fin("clocks.in");
	ofstream fout("clocks.out");
	
	clocks.alloc();
	for (i = 0; i < 9; i++)
		fin >> clocks.c[i];
	clocks.prev = NULL;
	clocks.moveType = 1;
	clocks.sameMoves = 0;
	cList.push_back(clocks);

	iter = cList.begin();
	find = false;
	while (!find && !cList.empty())
	{
		for (i = iter->moveType; i <= 9; i++)
		{
			if (iter->moveType == i && iter->sameMoves == 3) continue;
			clocks.alloc();
			move(i, *iter, clocks);
			find = add(clocks, cList);
			if (find)
				break;
		}
		iter->free();
		iter++;
	}

	print(fout, &clocks);

	return 0;
}