#include <stdio.h>
#include <string.h>

int main() {
	int k, h, w, i, j, jj, x, y, s;
	char buf[101], sky[1000][1001];
	int pos[20][20][2], num[20];
	bool find;

	memset(num, 0, 80);
	scanf("%d", &k);
	for (i = 0; i < k; i++) {
		scanf("%d%d ", &h, &w);
		//printf("%d %d\n", h, w);
		for (j = 0; j < h; j++) {
			//fread(buf, sizeof(char), w, stdin);
			gets(buf);
			//getchar();
			//printf("%s\n", buf);
			for (jj = 0; jj < w; jj++) {
				if (buf[jj] == '#') {
					pos[i][num[i]][0] = j;
					pos[i][num[i]++][1] = jj;
				}
			}
		}
	}

	scanf("%d%d ", &h, &w);
	//printf("%d %d\n", h, w);
	for (i = 0; i < h; i++) {
		gets(sky[i]);
		//printf("%s\n", sky[i]);
	}

	for (i = 0; i < k; i++) {
		for (j = 0; j < h; j++) {
			for (jj = 0; jj < w; jj++) {
				find = true;
				for (s = 0; s < num[i]; s++) {
					x = j + pos[i][s][0];
					y = jj + pos[i][s][1];
					if (x >= h || y >= w) {
						find = false;
						break;
					}
					if (sky[x][y] != '#') {
						find = false;
						break;
					}
				}
				if (find) break;
			}
			if (find) break;
		}
		if (find)
			printf("Yes\n");
		else
			printf("No\n");
	}		

	return 0;
}

