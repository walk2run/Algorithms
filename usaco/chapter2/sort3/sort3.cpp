/*
ID: iamyfy1
PROG: sort3
LANG: C++11
 */
#include <fstream>
using namespace std;

int main() {
  int n;
  int a[1000];
  ifstream fin("sort3.in");
  fin >> n;
  for (int i = 0; i < n; i++)
    fin >> a[i];
  fin.close();

  

  ofstream fout("sort3.out");
  fout.close();
  return 0;
}