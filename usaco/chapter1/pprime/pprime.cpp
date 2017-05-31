/*
ID: iamyfy1
PROG: pprime
LANG: C++11
 */

/* 
 * File:   pprime.cpp
 * Author: yfy
 *
 * Created on May 29, 2017, 4:57 PM
 */

#include <fstream>
#include <cmath>
using namespace std;

bool prime(int n) {
  for (int i = 2; i <= sqrt(n); i++)
    if (n % i == 0) return false;
  return true;
}

int main(int argc, char** argv) {
  int a, b, d1, d2, d3, d4, p;
  
  ifstream fin("pprime.in");
  fin >> a >> b;
  fin.close();
  
  ofstream fout("pprime.out");
  
  // 1
  for (p = 5; p <= 9; p += 2) {
    if (p > b) { fout.close(); return 0; }
    if (p >= a && prime(p)) fout << p << '\n';
  }
  
  if (a <= 11 && 11 <= b) fout << 11 << '\n';
  
  // 3
  for (d1 = 1; d1 <= 9; d1 += 2) {
    for (d2 = 0; d2 <= 9; d2++) {
      p = d1 * 100 + d2 * 10 + d1;
      if (p > b) { fout.close(); return 0; }
      if (p >= a && prime(p)) fout << p << '\n';
    }
  }
  
  // 5
  for (d1 = 1; d1 <= 9; d1 += 2) {
    for (d2 = 0; d2 <= 9; d2++) {
      for (d3 = 0; d3 <= 9; d3++) {
        p = d1 * 10000 + d2 * 1000 + d3 * 100 + d2 * 10 + d1;
        if (p > b) { fout.close(); return 0; }
        if (p >= a && prime(p)) fout << p << '\n';
      }
    }
  }
  
  // 7
  for (d1 = 1; d1 <= 9; d1 += 2) {
    for (d2 = 0; d2 <= 9; d2++) {
      for (d3 = 0; d3 <= 9; d3++) {
        for (d4 = 0; d4 <= 9; d4++) {
          p = d1 * 1000000 + d2 * 100000 + d3 * 10000 + d4 * 1000 + d3 * 100 + d2 * 10 + d1;
          if (p > b) { fout.close(); return 0; }
          if (p >= a && prime(p)) fout << p << '\n';
        }
      }
    }
  }
  
  fout.close();
  return 0;
}
