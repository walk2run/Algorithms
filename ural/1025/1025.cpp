#include <stdio.h>
#include <algorithm>
using namespace std;

int main() {
	int k, i, s;
	int a[101];

	scanf("%d", &k);
	for (i = 0; i < k; i++)
		scanf("%d", &a[i]);

	sort(a, a + k);
	s = 0;
	for (i = 0; i <= k / 2; i++)
		s += a[i] / 2 + 1;

	printf("%d\n", s);
	return 0;
}

