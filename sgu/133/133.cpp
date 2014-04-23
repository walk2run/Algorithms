#include <stdio.h>
#include <algorithm>

struct Pair
{
	int a, b;
};

bool cmp(const Pair &x, const Pair &y)
{
	return x.a < y.a;
}

int main()
{
	int n, i, max, count;
	Pair pairs[16000];
	
	scanf("%d", &n);
	for (i = 0; i < n; i++)
		scanf("%d %d", &(pairs[i].a), &(pairs[i].b));
	
	std::sort(pairs, pairs + n, cmp);
	
	max = pairs[0].b;
	count = 0;
	for (i = 1; i < n; i++)
	{
		if (max > pairs[i].b)
			count++;
		else if (pairs[i].b > max)
			max = pairs[i].b;
	}
	
	printf("%d\n", count);
	
	return 0;
}