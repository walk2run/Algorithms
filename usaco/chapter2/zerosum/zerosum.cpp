/*
ID: iamyfy1
PROG: zerosum
LANG: C++14
 */
#include <fstream>

int n;
char sbs[9];

std::ofstream fout("zerosum.out");

// sb, '0' -> None
void dfs(int i, int last, int sb, int result) {
  if (i == n) {
    switch (sb) {
      case '0': result = last; break;
      case '+': result += last; break;
      case '-': result -= last;
    }
    if (result == 0) {
      for (int i = 1; i < n; i++)
        fout << i << sbs[i - 1];
      fout << n << '\n';
    }
  } else {
    sbs[i - 1] = ' ';
    dfs(i + 1, last * 10 + i + 1, sb, result);
    switch (sb) {
      case '0': result = last; break;
      case '+': result += last; break;
      case '-': result -= last;
    }
    sbs[i - 1] = '+';
    dfs(i + 1, i + 1, '+', result);
    sbs[i - 1] = '-';
    dfs(i + 1, i + 1, '-', result);
  }
}

int main() {
  std::ifstream fin("zerosum.in");
  fin >> n;
  fin.close();
  dfs(1, 1, '0', 0);
  fout.close();
  return 0;
}