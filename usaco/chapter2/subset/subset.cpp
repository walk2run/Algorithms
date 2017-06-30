/*
ID: iamyfy1
PROG: subset
LANG: C++11
 */
#include <fstream>
using namespace std;

uint64_t solve(int n) {
  int sum = (n + 1) * n / 2;
  if (sum % 2 == 1) return 0;
  sum /= 2;
  uint64_t d[780];
  d[0] = 1;
  for (int i = 1; i <= n; i++) {
    for (int j = sum; j >= i; j--) {
      d[j] += d[j - i];
    }
  }
  return d[sum] / 2;
}

int main() {
  int n;
  ifstream fin("subset.in");
  fin >> n;
  fin.close();
  ofstream fout("subset.out");
  fout << solve(n) << '\n';
  fout.close();
  return 0;
}