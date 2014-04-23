#include <vector>
#include <algorithm>
#include <stdio.h>
using namespace std;

#define MAXN 100000

struct Pair
{
	int s, b, pos;
};

Pair pairs[MAXN];
Pair *lis[MAXN];
int pos[MAXN], path[MAXN];

int n;

bool cmp(const Pair &a, const Pair &b)
{
	return a.s < b.s || a.s == b.s && a.b > b.b;
}

// lower bound
Pair **LB(Pair **l, Pair **r, Pair *x)
{
	Pair **mid;
	while (1)
	{
		if (x->b <= (*l)->b) return l;
		mid = l + (r - l) / 2;
		if ((*mid)->b < x->b)
			l = mid + 1;
		else if ((*mid)->b == x->b)
			l = mid;
		else
			r = mid;
	}
}

// Longest Increasing Subsequence
void getLis()
{
	int i, j, len, lis_i;
	Pair *pair, **iter;
	
	if (n == 0) return;
	
	lis[0] = pairs;
	pos[0] = 0;
	lis_i = 0;
	for (i = 1; i < n; i++)
	{
		pair = pairs + i;
		if (pair->b > lis[lis_i]->b)
		{
			lis[++lis_i] = pairs + i;
			pos[i] = lis_i;
		}
		else
		{
			iter = LB(lis, lis + lis_i, pair);
			*iter = pair;
			pos[i] = iter - lis;
		}
	}
	
	j = lis_i;
	len = 0;
	for (i = n - 1; i >= 0 && j >= 0; i--)
		if (pos[i] == j)
		{
			path[len++] = pairs[i].pos;
			j--;
		}
	
	printf("%d\n%d", lis_i + 1, path[lis_i]);
	for (i = lis_i - 1; i >= 0; i--)
		printf(" %d", path[i]);
	printf("\n");
}

int main()
{
	int i;
	
	scanf("%d", &n);
	for (i = 0; i < n; i++)
	{
		scanf("%d %d", &(pairs[i].s), &(pairs[i].b));
		pairs[i].pos = i + 1;
	}
	
	sort(pairs, pairs + n, cmp);
	getLis();
	
	return 0;
}