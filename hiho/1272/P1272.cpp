#include <stdio.h>

void check(float a, int b, int &max) {
  if (int(a) == a && int(a) % 5 == 0 && b > max)
    max = b;
}

void solve() {
  int n, b[50], i, j, k, max;
  float a[50];
  scanf("%d", &n);
  for (i = 0; i < n; i++)
    scanf("%f%d", a + i, b + i);
  max = 0;
  for (i = 0; i < n; i++) {
    check(a[i], b[i], max);
    for (j = i + 1; j < n; j++) {
      check(a[i] + a[j], b[i] + b[j], max);
      for (k = j + 1; k < n; k++)
        check(a[i] + a[j] + a[k], b[i] + b[j] + b[k], max);
    }
  }
  printf("%d\n", max);
}

int main() {
  int q, i;
  scanf("%d", &q);
  for (i = 0; i < q; i++)
    solve();
  return 0;
}
