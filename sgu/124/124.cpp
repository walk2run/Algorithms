#include <stdio.h>

struct Line
{
	int x1, y1, x2, y2;
};

Line lines[10000];

void sort(int &a, int &b)
{
	int t;
	if (a > b)
	{
		t = a;
		a = b;
		b = t;
	}
}

int main()
{
	int n, i, x, y, count;
	Line *line;
	
	scanf("%d", &n);
	for (i = 0; i < n; i++)
		scanf("%d%d%d%d", &lines[i].x1, &lines[i].y1, &lines[i].x2, &lines[i].y2);
	scanf("%d%d", &x, &y);
	
	count = 0;
	for (i = 0; i < n; i++)
	{
		line = lines + i;
		sort(line->x1, line->x2);
		sort(line->y1, line->y2);
		if (line->y1 == line->y2 && x >= line->x1 && x <= line->x2 && y == line->y1 ||
			line->x1 == line->x2 && y >= line->y1 && y <= line->y2 && x == line->x1)
		{
			printf("BORDER\n");
			return 0;
		}
		if (line->y1 != line->y2 && x < line->x1 && y > line->y1 && y <= line->y2)
			count++;
	}
	
	if (count % 2)
		printf("INSIDE\n");
	else
		printf("OUTSIDE\n");
	
	return 0;
}