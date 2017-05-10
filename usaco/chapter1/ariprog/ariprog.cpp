/*
ID: iamyfy1
PROG: ariprog
LANG: C++11
 */

/* 
 * File:   ariprog.cpp
 * Author: yfy
 *
 * Created on May 9, 2017, 7:52 PM
 */

#include <stdio.h>
#include <bitset>
#include <vector>
#include <algorithm>

int n, m;
std::bitset<125001> bis;

void bisquare() {
  for (int i = 0; i <= m; i++) {
    int i2 = i * i;
    for (int j = 0; j <= m; j++)
      bis.set(i2 + j * j);
  }
}

struct Pair {
  int a, b;
  Pair(int a, int b) : a(a), b(b) {}
};

//bool cmp(const Pair &p1, const Pair &p2) {
//  return p1.b < p2.b || (p1.b == p2.b && p1.a < p2.a);
//}

bool cmp(const Pair *p1, const Pair *p2) {
  return p1->b < p2->b || (p1->b == p2->b && p1->a < p2->a);
}

int main() {
  FILE *fin = fopen("ariprog.in", "r");
  fscanf(fin, "%d %d", &n, &m);
  fclose(fin);
  
  bisquare();
  int maxBis = m * m * 2;
  std::vector<Pair*> list;
  for (int a = 0; a <= maxBis; a++) {
    for (int b = 1; ; b++) {
      if (a + (n - 1) * b <= maxBis) {
        int i = 0;
        for (i = 0; i < n; i++)
          if (!bis.test(a + i * b)) break;
        if (i == n) list.push_back(new Pair(a, b));
      } else break;
    }
  }
  
  std::sort(list.begin(), list.end(), cmp);
  
  FILE *fout = fopen("ariprog.out", "w");
  if (list.empty()) {
    fprintf(fout, "NONE\n");
  } else {
    for (Pair *p : list)
      fprintf(fout, "%d %d\n", p->a, p->b);
  }
  fclose(fout);
  return 0;
}

