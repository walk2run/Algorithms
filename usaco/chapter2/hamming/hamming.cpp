/*
ID: iamyfy1
PROG: hamming
LANG: C++11
 */
#include <fstream>
#include <vector>
using namespace std;

int n, b, d;
vector<int> list;

int dis(int a, int b) {
  int c = a ^ b;
  int d;
  for (d = 0; c; d++)
    c &= c - 1;
  return d;
}

bool check(int a) {
  for (int b : list)
    if (dis(a, b) < d) return false;
  return true;
}

int main() {
  ifstream fin("hamming.in");
  fin >> n >> b >> d;
  fin.close();

  int count = 0;
  for (int i = 0; count < n; i++) {
    if (check(i)) {
      list.push_back(i);
      count++;
    }
  }

  ofstream fout("hamming.out");
  for (int i = 0; i < list.size(); i++) {
    if (i % 10 == 9 || i == list.size() - 1)
      fout << list[i] << '\n';
    else
      fout << list[i] << ' ';
  }
  fout.close();
  return 0;
}