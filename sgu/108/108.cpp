#include <stdio.h>
#include <algorithm>

struct Pair
{
	int s, pos;
};

#define BASE 128

bool sn[BASE];
Pair pairs[5001];
int ans[5001];
int n, k;

bool cmp(const Pair &a, const Pair &b)
{
	return a.s < b.s;
}

void sieve()
{
	int i, count, next, t, pair_i;
	
	count = 0;
	pair_i = 0;
	for (i = 1; i <= n; i++)
	{
		if (!sn[i % BASE])
		{
			count++;
			while (count == pairs[pair_i].s)
				ans[pairs[pair_i++].pos] = i;
			//printf("%d ", i);
		}
		next = t = i;
		while (t)
		{
			next += t % 10;
			t /= 10;
		}
		sn[next % BASE] = true;
		sn[i % BASE] = false;
	}
	printf("%d\n%d", count, ans[0]);
	for (i = 1; i < k; i++)
		printf(" %d", ans[i]);
	printf("\n");
}

int main()
{
	int i;
	
	scanf("%d%d", &n, &k);
	for (i = 0; i < k; i++)
	{
		scanf("%d", &(pairs[i].s));
		pairs[i].pos = i;
	}
	
	std::sort(pairs, pairs + k, cmp);
	
	sieve();
	
	return 0;
}