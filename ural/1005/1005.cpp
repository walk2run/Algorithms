#include <stdio.h>
#include <string.h>

int main() {
	int n, i, s, s2, j;
	int w[20];
	bool d[1000000];

	scanf("%d", &n);
	s = 0;
	for (i = 0; i < n; i++) {
		scanf("%d", &w[i]);
		s += w[i];
	}

	s2 = s / 2;
	memset(d, 0, 1000000);
	d[0] = 1;
	for (i = 0; i < n; i++)
		for (j = s2; j >= w[i]; j--)
			d[j] |= d[j - w[i]];

	for (i = s2; i >= 0 && !d[i]; i--);
	printf("%d\n", s - i - i);

	return 0;
}
