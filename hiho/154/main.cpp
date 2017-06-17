#include <iostream>
#include <cmath>

using namespace std;

struct Circle {
  int x, y, r;
  bool visited;
};

istream &operator>>(istream &cin, Circle &c) {
  cin >> c.x >> c.y >> c.r;
  c.visited = false;
  return cin;
}

int w, h, n;
Circle cs[1000];

double dis(double x, double y) {
  return sqrt(x * x + y * y);
}

bool overlap(const Circle &a, const Circle &b) {
  return dis(a.x - b.x, a.y - b.y) <= a.r + b.r;
}

// whether can find a consecutive chain of circles to block the road
bool dfs(int p) {
  Circle &c = cs[p];
  if (c.visited) return false;
  c.visited = true;
  if (c.y + c.r >= h) return true;
  for (int i = 0; i < n; ++i)
    if (overlap(c, cs[i]) && dfs(i)) return true;
  return false;
}

string solve() {
  cin >> w >> h >> n;
  for (int i = 0; i < n; ++i)
    cin >> cs[i];
  for (int i = 0; i < n; ++i)
    if (cs[i].y - cs[i].r <= 0 && dfs(i)) return "NO";
  return "YES";
}

int main() {
  int t;
  cin >> t;
  for (int i = 0; i < t; ++i)
    cout << solve() << '\n';
  return 0;
}