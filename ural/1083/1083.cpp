#include <stdio.h>

int main() {
	int n, k, p, i;
	scanf("%d ", &n);
	k = 0;
	while (getchar() == '!') k++;
	p = 1;
	for (i = n; i >= k; i -= k)	p *= i;
	if (n % k > 0) p *= n % k;
	printf("%d\n", p);
	return 0;
}

