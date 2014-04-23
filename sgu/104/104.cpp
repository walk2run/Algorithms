#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int values[101][101];
int d[101][101];
bool use[101][101];
vector<int> path;

int main()
{
	int F, V, i, j, value1, value2;
	
	cin >> F >> V;
	for (i = 1; i <= F; i++)
		for (j = 1; j <= V; j++)
			cin >> values[j][i];	// flower i in vase j
	
	for (i = 1; i <= V; i++)	// vase
		for (j = max(F - (V - i), 1); j <= min(i, F); j++)
		{
			if (i - 1 < j)
				value1 = 1 << 31;
			else
				value1 = d[i-1][j];
			value2 = d[i-1][j-1] + values[i][j];
			if (value1 > value2)
			{
				use[i][j] = false;
				d[i][j] = value1;
			}
			else
			{
				use[i][j] = true;
				d[i][j] = value2;
			}
		}
	
	cout << d[V][F] << endl;
	
	i = V; j = F;
	while (path.size() < F)
	{
		while (!use[i][j]) i--;
		path.push_back(i);
		i--;
		j--;
	}
	
	cout << path.back();
	for (i = path.size() - 2; i >= 0; i--)
		cout << ' ' << path[i];
	cout << endl;
	
	/*for (i = 1; i <= V; i++)
	{
		for (j = 1; j <= F; j++)
			cout << d[i][j] << ' ';
		cout << endl;
	}*/
	
	return 0;
}