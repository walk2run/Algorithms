/*
ID: iamyfy1
PROG: lamps
LANG: C++11
 */
#include <fstream>
#include <vector>
#include <cstring>
#include <algorithm>

using namespace std;

const int N = 100;
int n, c, id;
vector<int> ons, offs;
bool ls[101];
vector<bool*> list;

bool check() {
  for (int i : ons)
    if (ls[i] == 0) return false;
  for (int i : offs)
    if (ls[i] == 1) return false;
  return true;
}

bool noDup() {
  for (bool *l : list) {
    bool same = true;
    for (int i = 1; i <= n; i++)
      if (ls[i] != l[i]) {same = false; break;}
    if (same) return false;
  }
  return true;
}

void btn1() {
  for (bool &b : ls) b = !b;
}

void btn2() {
  for (int i = 1; i <= n; i += 2)
    ls[i] = !ls[i];
}

void btn3() {
  for (int i = 2; i <= n; i += 2)
    ls[i] = !ls[i];
}

void btn4() {
  for (int i = 1; i <= n; i += 3)
    ls[i] = !ls[i];
}

void dfs(int depth) {
//  for (int i = 1; i <= n; i++)
//    cout << ls[i];
//  cout << '\n';
  if (depth == c + 1) {
    if (check() && noDup()) {
      bool *l = new bool[n + 1];
      memcpy(l, ls, n + 1);
      list.push_back(l);
    }
    return;
  }
  btn1(); dfs(depth + 1); btn1();
  btn2(); dfs(depth + 1); btn2();
  btn3(); dfs(depth + 1); btn3();
  btn4(); dfs(depth + 1); btn4();
}

bool cmp(bool *a, bool *b) {
  for (int i = 1; i <= n; i++) {
    if (a[i] < b[i]) return true;
    if (a[i] > b[i]) return false;
  }
  return false;
}

int main() {
  ifstream fin("lamps.in");
  fin >> n >> c;
  fin >> id;
  while (id != -1) {
    ons.push_back(id);
    fin >> id;
  }
  fin >> id;
  while (id != -1) {
    offs.push_back(id);
    fin >> id;
  }
  fin.close();

  if (c > 4) {
    if (c % 2 == 0) c = 4; else c = 3;
  }

  memset(ls, 1, n + 1);
  dfs(1);
  sort(list.begin(), list.end(), cmp);

  ofstream fout("lamps.out");
  for (bool *ls : list) {
    for (int i = 1; i <= n; i++)
      fout << ls[i];
    fout << '\n';
  }
  if (list.empty())
    fout << "IMPOSSIBLE\n";
  fout.close();
  return 0;
}

//// all on
//bool ao[N + 1];
//memset(ao, 1, sizeof(ao));
//
//// all off
//bool af[N + 1];
//memset(af, 0, sizeof(af));
//
//// even on, odd off
//bool eoof[N + 1];
//memset(eoof, 0, sizeof(eoof));
//for (int i = 2; i <= N; i += 2)
//eoof[i] = 1;
//
//// even off, odd on
//bool efoo[N + 1];
//memset(efoo, 0, sizeof(efoo));
//for (int i = 1; i <= n; i += 2)
//efoo[i] = 1;
//
//// 3k + 1 on
//bool ko[N + 1];
//for (int i = 1; i <= n; i++)
//ko[i] = i % 3 == 1 ? 1 : 0;
//
//// 3K + 1 off
//bool kf[N + 1];
//for (int i = 1; i <= n; i++)
//kf[i] = i % 3 == 1 ? 0 : 1;
//
//// 3, 4
//bool l7[N + 1];
//memset(l7, 0, sizeof(l7));
//for (int i = 0; i <= n; i += 2)
//l7[i] = 1;
//for (int i = 1; i <= n; i += 3)
//l7[i] = !l7[i];
//
//// 2, 4
//bool l8[N + 1];
//memset(l8, 0, sizeof(l8));
