#include <stdio.h>
const int MAX = ~(1 << 31);

void solve() {
  int n, m, k, t, i, j, cost, min, level, sum;
  int a[100], b[100], d[10001];
  scanf("%d%d%d%d", &n, &m, &k, &t);
  for (i = 0; i < m; i++)
    scanf("%d", a + i);
  for (i = 0; i < m; i++)
    scanf("%d", b + i);
  d[0] = sum = 0;
  for (level = 0; level < n; level++) {
    for (i = 1; i <= k; i++) {
      min = MAX;
      for (j = 0; j < m; j++) {
        cost = b[j] == 0 ? MAX : (i - b[j] < 0 ? 0 : d[i - b[j]]) + a[j];
        //printf("%d\n", cost);
        if (cost < min) min = cost;
      }
      d[i] = min;
    }
    //printf("%d\n", d[k]);
    if (d[k] == MAX) {
      printf("No Answer\n");
      return;
    }
    sum += d[k];
    for (i = 0; i < m; i++) b[i] /= t;
  }
  printf("%d\n", sum);
}

int main() {
  int q, i;
  scanf("%d", &q);
  for (i = 0; i < q; i++)
    solve();
  return 0;
}
