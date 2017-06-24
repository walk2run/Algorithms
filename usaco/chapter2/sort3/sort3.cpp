/*
ID: iamyfy1
PROG: sort3
LANG: C++11
 */
#include <fstream>
#include <cstring>

using namespace std;

int main() {
  int n;
  int a[1000], c[4], d[4][4];
  ifstream fin("sort3.in");
  fin >> n;
  for (int i = 0; i < n; i++)
    fin >> a[i];
  fin.close();

  memset(c, 0, sizeof(c));
  memset(d, 0, sizeof(d));
  for (int i = 0; i < n; i++)
    c[a[i]]++;
  int i;
  for (i = 0; i < c[1]; i++)
    d[1][a[i]]++;
  for (; i < c[1] + c[2]; i++)
    d[2][a[i]]++;
  for (; i < n; i++)
    d[3][a[i]]++;


  int sum = 0;
  int t = min(d[1][2], d[2][1]);
  sum += t;
  d[1][2] -= t; d[2][1] -= t;
  t = min(d[1][3], d[3][1]);
  sum += t;
  d[1][3] -= t; d[3][1] -= t;
  t = min(d[2][3], d[3][2]);
  sum += t;
  d[2][3] -= t; d[3][2] -= t;
  t = min(d[1][2], min(d[2][3], d[3][1]));
  sum += t * 2;
  d[1][2] -= t; d[2][3] -= t; d[3][1] -= t;
  t = min(d[1][3], min(d[2][1], d[3][2]));
  sum += t * 2;

  ofstream fout("sort3.out");
  fout << sum << '\n';
  fout.close();
  return 0;
}