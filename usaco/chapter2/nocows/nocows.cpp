/*
ID: iamyfy1
PROG: nocows
LANG: C++11
 */
/*
 * Dynamic programming
 */
#include <fstream>
using namespace std;

int main() {
  int n, k;
  ifstream fin("nocows.in");
  fin >> n >> k;
  fin.close();

  int d[200][100] = {0};
  for (int i = 1; i <= k; i++)
    d[1][i] = 1;
  for (int j = 1; j <= k; j++) {
    for (int i = 1; i <= n; i += 2) {
      for (int u = 1; u < i; u += 2)
        d[i][j] = (d[i][j] + d[u][j - 1] * d[i - 1 - u][j - 1]) % 9901;
    }
  }

  ofstream fout("nocows.out");
  fout << (d[n][k] - d[n][k - 1] + 9901) % 9901 << endl;
  fout.close();
  return 0;
}