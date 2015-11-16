#include <stdio.h>

int main() {
	int n, s;
	scanf("%d", &n);
	if (n >= 1)
		s = (1 + n) * n / 2;
	else
		s = (1 + n) * (2 - n) / 2;
	printf("%d\n", s);
}

