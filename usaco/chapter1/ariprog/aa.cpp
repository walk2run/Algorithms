/*
	ID:iamyfy1
	LANG:C++
	PROG:ariprog
*/
#include <iostream>
#include <cstdio>
#include <algorithm>
using namespace std;
 
#define MAX_NUM 65536
#define RES_NUM 10100
 
typedef struct TagNode
{
	int a;
	int b;
}Node;
 
int e[MAX_NUM], el;
bool flag[MAX_NUM] = {0};
Node res[RES_NUM];
int idx;
int n, m;
 
void init()
{
	int i, j, k, tmp;
	k = idx = 0;
	for(i = 0; i <= m; ++i)
		for(j = i; j <= m; ++j)
		{
			tmp = i*i + j*j;
			if(!flag[tmp])
			{
				e[k] = tmp;
				++k;
				flag[tmp] = true;
			}
		}
	el = k;
	sort(e, e + el);
}
 
template<class T>
struct cmp
{
public:
	bool operator()(const T& x, const T& y) const
	{
		if(x.b != y.b)
			return x.b < y.b;
		return x.a < y.a;
	}
};
 
void work()
{
	int i, j;
	int d, l;
	int maxe = 2*m*m;
	for(i = 0; i < el; ++i)
	{
		for(j = i + 1; j < el; ++j)
		{
			d = e[j] - e[i];
			l = 2;
			//关键剪枝注意是break而不是continue
			if(e[i] + (n-1)*d > maxe)break;
			while(l < n && binary_search(e, e + el, e[i]+l*d))
			{
				++l;
			}
			if(l == n)
			{
				res[idx].a = e[i];
				res[idx].b = d;
				++idx;
			}
		}
	}
	sort(res, res+idx, cmp<Node>());
}
 
inline void get_input()
{
	FILE *fin = fopen("ariprog.in", "r");
	fscanf(fin, "%d %d", &n, &m);
	fclose(fin);
}
 
void get_output()
{
	FILE *fout = fopen("ariprog.out", "w");
	int i;
	if(idx == 0)
	{
		fprintf(fout, "NONE\n");
		return ;
	}
	for(i = 0; i < idx; ++i)
	{
		fprintf(fout, "%d %d\n", res[i].a, res[i].b);
	}
	fclose(fout);
}
 
int main(int argc, char **argv)
{
	get_input();
	init();
	work();
	get_output();
	return 0;
}
