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

  ofstream fout("sort3.out");
  fout.close();
  return 0;
}