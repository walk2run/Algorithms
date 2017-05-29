/*
ID: iamyfy1
PROG: numtri
LANG: C++11
 */

/* 
 * File:   numtri.cpp
 * Author: yfy
 *
 * Created on May 29, 2017, 4:33 PM
 */

#include <fstream>
using namespace std;

int main(int argc, char** argv) {
  int r;
  int a[1000][1000];
  ifstream fin("numtri.in");
  fin >> r;
  for (int i = 0; i < r; i++)
    for (int j = 0; j <= i; j++)
      fin >> a[i][j];
  fin.close();
  
  for (int i = r - 2; i >= 0; i--)
    for (int j = 0; j <= i; j++)
      a[i][j] += max(a[i + 1][j], a[i + 1][j + 1]);
  
  ofstream fout("numtri.out");
  fout << a[0][0] << endl;
  fout.close();
  return 0;
}

