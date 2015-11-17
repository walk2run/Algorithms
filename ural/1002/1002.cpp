#include <stdio.h>
#include <string.h>

const char map[26] = {'2', '2', '2', '3', '3', '3', '4', '4', '1', '1', '5',
	'5', '6', '6', '0', '7', '0', '7', '7', '8', '8', '8', '9', '9', '9', '0'};

void solve() {
	int n, i, j, len, lenw, count;
	int f[100], prev[100], list[100];
	char number[101], owords[50000][51], words[50000][51], *p;
	
	gets(number);
	//printf("%s\n", number);
	scanf("%d ", &n);
	for (i = 0; i < n; i++) {
		gets(words[i]);
		strcpy(owords[i], words[i]);
		for (p = words[i]; *p; p++)
			*p = map[(*p) - 'a'];
		//printf("%s\n", words[i]);
	}

	memset(f, 0xff, sizeof(f));
	len = strlen(number);
	for (i = 0; i < len; i++) {
		for (j = 0; j < n; j++) {
			lenw = strlen(words[j]);
			if (lenw <= i + 1 && !strncmp(words[j], number + i - lenw + 1, lenw)) {
				if (i - lenw < 0) {
					f[i] = 1;
					prev[i] = j;
				} else if (f[i - lenw] + 1 < f[i] || f[i] == -1) {
					f[i] = f[i - lenw] + 1;
					prev[i] = j;
				}
			}
		}
	}
	/*for (i = 0; i < len; i++)
		printf("%d ", f[i]);
	printf("\n");*/
	if (f[len - 1] == -1)
		printf("No solution.\n");
	else {
		i = len - 1;
		count = 0;
		while (i >= 0) {
			list[count++] = prev[i];
			i -= strlen(words[prev[i]]);
		}
		for (i = count - 1; i > 0; i--)
			printf("%s ", owords[list[i]]);
		printf("%s\n", owords[list[0]]);
	}
}

int main() {
	char c;
	solve();
	while ((c = getchar()) != '-') {
		ungetc(c, stdin);
		solve();
	}
	return 0;
}

