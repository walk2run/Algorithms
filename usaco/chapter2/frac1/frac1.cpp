/*
ID: iamyfy1
PROG: frac1
LANG: C++11
 */
// Farey Sequences. Interesting
#include <fstream>
using namespace std;

int n;
ofstream fout("frac1.out");

void search(int a, int b, int c, int d) {
  int e = a + c;
  int f = b + d;
  if (e > n || f > n) return;
  search(a, b, e, f);
  fout << e << '/' << f << '\n';
  search(e, f, c, d);
}

int main() {
  ifstream fin("frac1.in");
  fin >> n;
  fin.close();
  fout << "0/1\n";
  search(0, 1, 1, 1);
  fout << "1/1\n";
  return 0;
}