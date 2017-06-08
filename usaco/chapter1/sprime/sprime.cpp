/*
ID: iamyfy1
PROG: sprime
LANG: C++11
 */

#include <fstream>
#include <cmath>

using namespace std;

int n;
ofstream fout("sprime.out");

bool prime(int num) {
  for (int i = 2; i <= sqrt(num); i++)
    if (num % i == 0) return false;
  return true;
}

void dfs(int num, int pos) {
  if (!prime(num)) return;
  if (pos == n) {
    fout << num << '\n';
    return;
  }
  for (int i = 1; i <= 9; i += 2)
    dfs(num * 10 + i, pos + 1);
}

int main() {
  ifstream fin("sprime.in");
  fin >> n;
  fin.close();
  for (int i : {2, 3, 5, 7})
    dfs(i, 1);
  fout.close();
  return 0;
}