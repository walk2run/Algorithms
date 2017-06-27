/*
ID: iamyfy1
PROG: preface
LANG: C++11
 */
#include <fstream>
using namespace std;

int ci, cv, cx, cl, cc, cd, cm;

void roman(int n) {
  int m = n / 1000;
  cm += m;
  n %= 1000;

  int c = n / 100;
  if (c <= 3) cc += c;
  else if (c == 4) {cc++; cd++;}
  else if (c <= 8) {cc += c - 5; cd++;}
  else {cc++; cm++;}
  n %= 100;

  int x = n / 10;
  if (x <= 3) cx += x;
  else if (x == 4) {cx++; cl++;}
  else if (x <= 8) {cx += x - 5; cl++;}
  else {cx++; cc++;}
  n %= 10;

  if (n <= 3) ci += n;
  else if (n == 4) {ci++; cv++;}
  else if (n <= 8) {ci += n - 5; cv++;}
  else {ci++; cx++;}
}

int main() {
  int n;
  ifstream fin("preface.in");
  fin >> n;
  fin.close();

  for (int i = 1; i <= n; i++)
    roman(i);

  ofstream fout("preface.out");
  if (ci > 0) fout << "I " << ci << '\n';
  if (cv > 0) fout << "V " << cv << '\n';
  if (cx > 0) fout << "X " << cx << '\n';
  if (cl > 0) fout << "L " << cl << '\n';
  if (cc > 0) fout << "C " << cc << '\n';
  if (cd > 0) fout << "D " << cd << '\n';
  if (cm > 0) fout << "M " << cm << '\n';
  fout.close();
  return 0;
}