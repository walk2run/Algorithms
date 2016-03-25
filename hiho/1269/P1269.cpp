#include <stdio.h>
#include <queue>

int n;
long long q;
int p[100000];

bool ok(int size) {
  std::priority_queue<int> que;
  int count;
  long long sum;
  count = sum = 0;
  for (int i = 0; i < n; i++) {
    if (que.size() < size)
      que.push(p[i]);
    else {
      sum += ++count * que.top();
      if (sum > q) return false;
      que.pop();
      que.push(p[i]);
    }
  }
  while (!que.empty()) {
    sum += ++count * que.top();
    if (sum > q) return false;
    que.pop();
  }
  return true;
}

int main() {
  int i, l, r, mid;
  scanf("%d%lld", &n, &q);
  for (i = 0; i < n; i++)
    scanf("%d", p + i);

  l = 1;
  r = n + 1;
  while (l < r) {
    mid = (l + r) / 2;
    if (ok(mid))
      r = mid;
    else
      l = mid + 1;
  }
  printf("%d\n", l > n ? -1 : l);
  return 0;
}
