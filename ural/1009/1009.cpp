#include <stdio.h>
#include <stdint.h>

int main() {
	int n, k, i;
	uint64_t f[17];
	scanf("%d%d", &n, &k);
	f[0] = 1;
	f[1] = k - 1;
	for (i = 2; i <= n; i++)
		f[i] = (k - 1) * (f[i - 2] + f[i - 1]);
	printf("%llu\n", f[n]);
	return 0;
}

