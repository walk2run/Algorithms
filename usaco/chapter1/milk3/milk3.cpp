/*
ID: iamyfy1
PROG: milk3
LANG: C++11
 */

/* 
 * File:   milk3.cpp
 * Author: yfy
 *
 * Created on May 11, 2017, 11:13 AM
 */

#include <fstream>
#include <string.h>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

int A, B, C;
bool exist[21][21][21];
vector<int> list;

void dfs(int a, int b, int c) {
  if (exist[a][b][c]) return;
  exist[a][b][c] = true;
  if (a == 0) list.push_back(c);
  
  int t = min(a, B - b);
  dfs(a - t, b + t, c);
  
  t = min(a, C - c);
  dfs(a - t, b, c + t);
  
  t = min(b, A - a);
  dfs(a + t, b - t, c);
  
  t = min(b, C - c);
  dfs(a, b - t, c + t);
  
  t = min(c, A - a);
  dfs(a + t, b, c - t);
  
  t = min(c, B - b);
  dfs(a, b + t, c - t);
}

int main(int argc, char** argv) {
  ifstream fin("milk3.in");
  fin >> A >> B >> C;
  fin.close();
  
  memset(exist, 0, sizeof(exist));
  dfs(0, 0, C);
  sort(list.begin(), list.end());
  
  ofstream fout("milk3.out");
  if (!list.empty()) fout << list[0];
  for (int i = 1; i < list.size(); i++)
    fout << ' ' << list[i];
  fout << endl;
  fout.close();
  
  return 0;
}
