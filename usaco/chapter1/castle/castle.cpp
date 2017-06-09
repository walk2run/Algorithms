#include <fstream>

using namespace std;

int m, n, area;
int map[50][50];
bool visit[50][50];

void dfs(int x, int y) {
  if (visit[x][y]) return;
  visit[x][y] = true;
  area++;
  int v = map[x][y];
  if (!(v & 1)) dfs(x, y - 1);
  if (!(v & 2)) dfs(x - 1, y);
  if (!(v & 4)) dfs(x, y + 1);
  if (!(v & 8)) dfs(x + 1, y);
}

int main() {
  ifstream fin("castle.in");
  fin >> m >> n;
  for (int i = 0; i < n; i++)
    for (int j = 0; j < m; j++)
      fin >> map[i][j];
  fin.close();

  int maxArea = 0, count = 0;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      area = 0;
      if (!visit[i][j]) count++, dfs(i, j);
      maxArea = max(maxArea, area);
    }
  }
  ofstream fout("castle.out");
  fout << count << '\n' << maxArea << '\n';

  return 0;
}