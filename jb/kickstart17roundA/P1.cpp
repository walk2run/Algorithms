#include <stdio.h>
#include <algorithm>

FILE *fin = fopen("A-large-practice.in", "r");
FILE *fout = fopen("A-large.out", "w");

void solve(int n, int m) {
  unsigned long long sum = 0;
  for (unsigned long long i = 1; i < std::min(n, m); i++)
    sum = (sum + (n - i) * (m - i) % 1000000007 * i) % 1000000007;
  fprintf(fout, "%u\n", sum);
}

int main() {  
  int t, n, m;
  fscanf(fin, "%d", &t);
  for (int i = 1; i <= t; i++) {
    fprintf(fout, "Case #%d: ", i);
    fscanf(fin, "%d %d", &n, &m);
    solve(n, m);
  }
  fclose(fin);
  fclose(fout);
}
