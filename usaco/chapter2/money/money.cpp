/*
ID: iamyfy1
PROG: money
LANG: C++14
 */
#include <iostream>
#include <fstream>

int main() {
  std::ifstream fin("money.in");
  int v, n, a;
  fin >> v  >> n;
  long long d[10001] = {1};
  for (int i = 0; i < v; ++i) {
    fin >> a;
    for (int j = a; j <= n; ++j)
      d[j] += d[j - a];
  }
  std::ofstream fout("money.out");
  fout << d[n] << '\n';
  fout.close();
  return 0;
}