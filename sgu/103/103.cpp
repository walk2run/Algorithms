#include <iostream>
#include <queue>
#include <vector>
using namespace std;

struct Vertex
{
	char color;
	unsigned tr, tb, tp, len, prev;	// time remain, blue, purple
	bool in;
};

struct Node
{
	int dst, len;
	Node *next;
};

Vertex vlist[301];

Node *heads[301];	// graph

queue<int> que;

//int n;

void tool(int time, int v, char &color, int &t1, int &t2)
{
	Vertex *vp;
	int remain;
	
	vp = vlist + v;
	if (time < vp->tr)
	{
		color = vp->color;
		t1 = vp->tr - time;
		if (vp->color == 'B')
			t2 = vp->tp;
		else
			t2 = vp->tb;
	}
	else
	{
		remain = (time - vp->tr) % (vp->tb + vp->tp);
		if (vp->color == 'B')
		{
			if (remain < vp->tp)
			{
				color = 'P';
				t1 = vp->tp - remain;
				t2 = vp->tb;
			}
			else
			{
				color = 'B';
				t1 = vp->tp + vp->tb - remain;
				t2 = vp->tp;
			}
		}
		else
		{
			if (remain < vp->tb)
			{
				color = 'B';
				t1 = vp->tb - remain;
				t2 = vp->tp;
			}
			else
			{
				color = 'P';
				t1 = vp->tp + vp->tb - remain;
				t2 = vp->tb;
			}
		}
	}
	//cout << time << ' ' << v << ' ' << color << ' ' << t1 << ' ' << t2 << endl;
}

int caltime(int time, int v1, int v2)
{
	char color1, color2;
	int t1Fst, t1Snd, t2Fst, t2Snd;
	
	tool(time, v1, color1, t1Fst, t1Snd);
	tool(time, v2, color2, t2Fst, t2Snd);
	
	if (color1 == color2) return 0;
	if (t1Fst < t2Fst) return t1Fst;
	if (t1Fst > t2Fst) return t2Fst;
	if (t1Snd < t2Snd) return t1Fst + t1Snd;
	if (t1Snd > t2Snd) return t1Fst + t2Snd;
	return -1;
}

void spfa()
{
	Node *node;
	int len, v, dst, i, timeNeed;
	
	while (que.size() > 0)
	{
		v = que.front();
		/*cout << v << ' ' << que.size() << ' ';
		for (i = 1; i <= n; i++)
			cout << vlist[i].len << ' ';
		cout << endl;*/
		node = heads[v];
		while (node)
		{
			dst = node->dst;
			timeNeed = caltime(vlist[v].len, v, dst);
			//cout << "time: " << vlist[v].len << ' ' << v << ' ' << dst << ' ' << timeNeed << endl;
			if (timeNeed == -1)
			{
				node = node->next;
				continue;
			}
			len = vlist[v].len + node->len + timeNeed;
			if (len < vlist[dst].len)
			{
				vlist[dst].len = len;
				vlist[dst].prev = v;
				if (!vlist[dst].in)
				{
					que.push(dst);
					vlist[dst].in = true;
				}
			}
			node = node->next;
		}
		vlist[v].in = false;
		que.pop();
	}
}

int main()
{
	int src, dst, n, m, i, v1, v2, len;
	char color;
	Node *node;
	vector<int> path;
	
	cin >> src >> dst >> n >> m;
	for (i = 1; i <= n; i++)
	{
		cin >> vlist[i].color >> vlist[i].tr >> vlist[i].tb >> vlist[i].tp;
		//cout << vlist[i].color << endl;
		vlist[i].len = -1;
	}
	for (i = 0; i < m; i++)
	{
		cin >> v1 >> v2 >> len;
		
		node = new Node;
		node->next = heads[v1];
		node->dst = v2;
		node->len = len;
		heads[v1] = node;
		
		node = new Node;
		node->next = heads[v2];
		node->dst = v1;
		node->len = len;
		heads[v2] = node;
	}
	
	vlist[src].len = vlist[src].prev = vlist[src].in = 0;
	que.push(src);
	spfa();
	
	if (vlist[dst].len == -1)
	{
		cout << "0\n";
	}
	else
	{
		cout << vlist[dst].len << endl;
		while (dst > 0)
		{
			path.push_back(dst);
			dst = vlist[dst].prev;
		}
		cout << path.back();
		for (i = path.size() - 2; i >= 0; i--)
			cout << ' ' << path[i];
		cout << endl;
	}
	
	//for (i = 1; i <= n; i++)
	//	cout << vlist[i].len << ' ' << vlist[i].prev << endl;
	
	return 0;
}