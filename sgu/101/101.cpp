#include <iostream>
using namespace std;

struct Edge
{
	int v1, v2;
};

int n;
int g[7][7];
Edge edges[100];

void findEdge(int v1, int v2)
{
	int i;
	
	for (i = 0; i < n; i++)
	{
		if (edges[i].v1 == v1 && edges[i].v2 == v2)
		{
			cout << i + 1 << " -\n";
			edges[i].v1 = edges[i].v2 = -1;
			break;
		}
		else if	(edges[i].v1 == v2 && edges[i].v2 == v1)
		{
			cout << i + 1 << " +\n";
			edges[i].v1 = edges[i].v2 = -1;
			break;
		}
	}	
}

bool dfs(int v, int len)
{
	int i;
	
	if (len == n) return true;
	for (i = 0; i <= 6; i++)
	{
		if (g[v][i] > 0)
		{
			g[v][i]--;
			g[i][v]--;
			if (dfs(i, len + 1))
			{
				//cout << v << ' ' << i << endl;
				findEdge(v, i);
				return true;
			}
			g[v][i]++;
			g[v][i]++;
		}
	}
	return false;
}

int main()
{
	int i, j, v1, v2, degree, oddCount;
	int odds[2];
	
	cin >> n;
	for (i = 0; i < n; i++)
	{
		cin >> v1 >> v2;
		g[v1][v2]++;
		g[v2][v1]++;
		edges[i].v1 = v1;
		edges[i].v2 = v2;
	}
	
	oddCount = 0;
	for (i = 0; i <= 6; i++)
	{
		degree = 0;
		for (j = 0; j <= 6; j++)
			degree += g[i][j];
		if (degree % 2 != 0) odds[oddCount++] = i;
	}
		
	if (oddCount != 0 && oddCount != 2)
	{
		cout << "No solution\n";
		return 0;
	}
	
	if (oddCount == 2)
	{
		if (!dfs(odds[0], 0)) cout << "No solution\n";
	}
	else
	{
		for (i = 0; i <= 6; i++)
			if (dfs(i, 0)) return 0;
		cout << "No solution\n";
	}
	
	return 0;
}