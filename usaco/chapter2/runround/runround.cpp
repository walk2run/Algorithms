/*
ID: iamyfy1
PROG: runround
LANG: C++11
 */
#include <fstream>
#include <vector>
#include <cstring>
using namespace std;

bool rr(int m) {
  vector<int> ds;
  while (m) {
    ds.push_back(m % 10);
    m /= 10;
  }
  bool use[10];
  memset(use, 0, sizeof(use));
  for (int d : ds) {
    if (use[d] || d == 0) return false;
    use[d] = true;
  }
  memset(use, 0, sizeof(use));
  int len = ds.size();
  int i = len - 1;
  use[i] = true;
  while (true) {
    i = (i - ds[i]);
    while (i < 0) i += len;
    if (use[i]) break;
    use[i] = true;
  }
  if (i == len - 1) {
    for (int j = 0; j < len; j++)
      if (!use[j]) return false;
    return true;
  }
  return false;
}

int solve(int m) {
  while (!rr(++m));
  return m;
}

int main() {
  int m;
  ifstream fin("runround.in");
  fin >> m;
  fin.close();
  ofstream fout("runround.out");
  fout << solve(m) << '\n';
  fout.close();
  return 0;
}