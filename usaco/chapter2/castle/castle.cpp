/*
ID: iamyfy1
PROG: castle
LANG: C++11
 */
#include <fstream>
using namespace std;

int m, n, area, count;
int map[50][50], visit[50][50];
int areas[2500];

void dfs(int x, int y) {
  if (visit[x][y]) return;
  visit[x][y] = count;
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

  int maxArea = 0;
  for (int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      if (!visit[i][j]) {
        area = 0, count++, dfs(i, j);
        areas[count] = area;
      }
      maxArea = max(maxArea, area);
    }
  }
  ofstream fout("castle.out");
  fout << count << '\n' << maxArea << '\n';

  maxArea = 0;
  int maxx, maxy;
  char dir;
  for (int j = 0; j < m; j++) {
    for (int i = n - 1; i >= 0; i--) {
      if (i > 0 && map[i][j] & 2) {
        int v1 = visit[i][j];
        int v2 = visit[i - 1][j];
        int newArea = areas[v1] + areas[v2];
        if (v1 != v2 &&  newArea > maxArea) {
          maxArea = newArea;
          maxx = i, maxy = j, dir = 'N';
        }
      }
      if (j < m - 1 && map[i][j] & 4) {
        int v1 = visit[i][j];
        int v2 = visit[i][j + 1];
        int newArea = areas[v1] + areas[v2];
        if (v1 != v2 && newArea > maxArea) {
          maxArea = newArea;
          maxx = i, maxy = j, dir = 'E';
        }
      }
    }
  }
  fout << maxArea << '\n' << maxx + 1 << ' ' << maxy + 1 << ' ' << dir << '\n';
  fout.close();
  return 0;
}