#include <stdio.h>

unsigned long long f[31];

int main()
{
	int k, i, j;
	
	scanf("%d", &k);
	
	f[0] = 1;
	for (i = 1; i <= k; i++)
		for (j = 0; j < i; j++)
			f[i] += f[j] * f[i-j-1];
	
	printf("%llu %d\n", f[k], k+1);
	
	return 0;
}