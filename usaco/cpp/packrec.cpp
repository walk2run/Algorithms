/*
LANG: C++
PROG: packrec
*/
#include <fstream>
#include <vector>
#include <algorithm>
using namespace std;

struct Rec
{
	int w, h, area;

	Rec(){}

	Rec(int w, int h): w(w), h(h)
	{
		if (w > h)
		{
			this->w = h;
			this->h = w;
		}
		area = w * h;
	}

	void swap()
	{
		int t;
		t = w;
		w = h;
		h = t;
	}
};

bool cmpArea(const Rec &a, const Rec &b)
{
	return a.area < b.area;
}

vector<Rec> ans;

/*void print(Rec recs[], int type, int w, int h)
{
	for (int i = 0; i < 4; i++)
		fout << recs[i].w << ' ' << recs[i].h << ' ';
	fout << "   " << type << ' ' << w << ' ' << h << ' ' << w * h << endl;
}*/

void try1(Rec recs[])
{
	int w, h;
	w = recs[0].w + recs[1].w + recs[2].w + recs[3].w;
	h = max(max(recs[0].h, recs[1].h), max(recs[2].h, recs[3].h));
	ans.push_back(Rec(w, h));
	//print(recs, 1, w, h);
}

void try2(Rec recs[])
{
	int w, h;
	w = max(recs[0].w + recs[1].w + recs[2].w, recs[3].w);
	h = max(max(recs[0].h, recs[1].h), recs[2].h) + recs[3].h;
	ans.push_back(Rec(w, h));
	//print(recs, 2, w, h);
}

void try3(Rec recs[])
{
	int w, h;
	w = max(recs[0].w + recs[1].w, recs[2].w) + recs[3].w;
	h = max(max(recs[0].h, recs[1].h) + recs[2].h, recs[3].h);
	ans.push_back(Rec(w, h));
	//print(recs, 3, w, h);
}

void try4(Rec recs[])
{
	int w, h;
	w = recs[0].w + recs[1].w + max(recs[2].w, recs[3].w);
	h = max(max(recs[0].h, recs[1].h), recs[2].h + recs[3].h);
	ans.push_back(Rec(w, h));
	//print(recs, 4, w, h);
}

void try5(Rec recs[])
{
	int w, h;
	h = max(recs[0].h + recs[2].h, recs[1].h + recs[3].h);
	if (recs[2].h >= recs[1].h + recs[3].h)
		w = max(recs[0].w, recs[2].w + max(recs[1].w, recs[3].w));
	else if (recs[2].h > recs[3].h)
		w = max(recs[0].w + recs[1].w, recs[2].w + max(recs[1].w, recs[3].w));
	else if (recs[3].h >= recs[0].h + recs[2].h)
		w = max(recs[1].w, recs[3].w + max(recs[0].w, recs[2].w));
	else if (recs[3].h > recs[2].h)
		w = max(recs[0].w + recs[1].w, recs[3].w + max(recs[0].w, recs[2].w));
	else
		w = max(recs[0].w + recs[1].w, recs[2].w + recs[3].w);
	ans.push_back(Rec(w, h));
	//print(recs, 5, w, h);
}

void swapWh(int depth, Rec recs[])
{
	if (depth == 4)
	{
		try1(recs);
		try2(recs);
		try3(recs);
		try4(recs);
		try5(recs);
	}
	else
	{
		swapWh(depth + 1, recs);
		recs[depth].swap();
		swapWh(depth + 1, recs);
		recs[depth].swap();
	}
}

void permutation(int depth, bool used[], int perm[], Rec recs[])
{
	int i;
	if (depth == 4)
	{
		static Rec tryRecs[4];
		for (i = 0; i < 4; i++)
			tryRecs[i] = recs[perm[i]];
		swapWh(0, tryRecs);
	}
	else
	{
		for (i = 0; i < 4; i++)
			if (!used[i])
			{
				perm[depth] = i;
				used[i] = true;
				permutation(depth+1, used, perm, recs);
				used[i] = false;
			}
	}
}

class AnswerList
{
public:
	void add(Rec *rec)
	{
		for (int i = 0; i < list.size(); i++)
			if (rec->w == list[i]->w && rec->h == list[i]->h) return;
		list.push_back(rec);
	}

	static bool cmpW(Rec *a, Rec *b)
	{
		return a->w < b->w;
	}

	void sortRecs()
	{
		sort(list.begin(), list.end(), cmpW);
	}

	void print(ofstream &fout)
	{
		for (int i = 0; i < list.size(); i++)
			fout << list[i]->w << ' ' << list[i]->h << endl;
	}

private:
	vector<Rec *> list;
};

int main()
{
	int i, minArea;
	Rec recs[4];
	bool used[4];
	int perm[4];
	AnswerList list;

	ifstream fin("packrec.in");
	ofstream fout("packrec.out");

	for (i = 0; i < 4; i++)
	{
		fin >> recs[i].w >> recs[i].h;
		used[i] = false;
	}

	permutation(0, used, perm, recs);
	
	minArea = min_element(ans.begin(), ans.end(), cmpArea)->area;
	for (i = 0; i < ans.size(); i++)
	{
		if (ans[i].area == minArea)
			list.add(&ans[i]);
	}
	list.sortRecs();

	fout << minArea << endl;
	list.print(fout);

	return 0;
}