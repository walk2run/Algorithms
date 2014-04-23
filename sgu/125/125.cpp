#include <stdio.h>

int n;
int B[3][3], A[3][3];

int judge(int r, int c)
{
	int center, count;
	
	center = A[r][c];
	count = 0;
	if (r-1 >= 0)
		if (A[r-1][c] > center) count++;
	if (r+1 < n)
		if (A[r+1][c] > center) count++;
	if (c-1 >= 0)
		if (A[r][c-1] > center) count++;
	if (c+1 < n)
		if (A[r][c+1] > center) count++;
	return count;
}

bool search(int depth)
{
	int r, c, i, count;
	
	if (depth == n * n) return true;
	r = depth / n;
	c = depth % n;
	for (i = 0; i <= 9; i++)
	{
		A[r][c] = i;
		if (r > 0)
		{
			count = judge(r-1, c);
			if (count > B[r-1][c])
				break;
			else if (count < B[r-1][c])
				continue;
		}
		if (r == n - 1 && c > 0)
		{
			count = judge(r, c-1);
			if (count > B[r][c-1])
				break;
			else if (count < B[r][c-1])
				continue;
		}
		if (r == n - 1 && c == n - 1)
		{
			count = judge(r, c);
			if (count < B[r][c])
				break;
			else if (count > B[r][c])
				continue;
		}
		if (search(depth + 1)) return true;
	}
	return false;
}

int main()
{
	int i, j;
	
	scanf("%d", &n);
	for (i = 0; i < n; i++)
		for (j = 0; j < n; j++)
			scanf("%d", &(B[i][j]));
	
	if (search(0))
		for (i = 0; i < n; i++)
		{
			printf("%d", A[i][0]);
			for (j = 1; j < n; j++)
				printf(" %d", A[i][j]);
			printf("\n");
		}
	else
		printf("NO SOLUTION\n");
	
	return 0;
}