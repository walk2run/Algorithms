#include <stdio.h>

void solve()
{
	int n, i, a, product, sum;
	
	scanf("%d%d", &n, &a);
	if (a == 0)
	{
		printf("0\n");
		return;
	}
	sum = product = a % 9;
	for (i = 1; i < n; i++)
	{
		scanf("%d", &a);
		product = product * (a % 9) % 9;
		sum = (sum + product) % 9;
	}
	if (sum == 0) sum = 9;
	printf("%d\n", sum);
}

int main()
{
	int k, i;
	
	scanf("%d", &k);
	for (i = 0; i < k; i++)
		solve();
	
	return 0;
}