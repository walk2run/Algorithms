/*
ID: iamyfy1
PROG: holstein
LANG: C++11
 */
#include <fstream>
#include <vector>
using namespace std;

int v, g, minCount;
int req[25], sum[25], amt[15][25];
vector<int> path, pathAns;

void search(int type) {
  if (type == g) return;
  // select
  path.push_back(type);
  for (int i = 0; i < v; i++)
    sum[i] += amt[type][i];
  bool ok = true;
  for (int i = 0; i < v; i++)
    if (sum[i] < req[i]) { ok = false; break; }
  if (ok && path.size() < minCount) {
    minCount = (int)path.size();
    pathAns = path;
  }
  search(type + 1);
  path.pop_back();
  for (int i = 0; i < v; i++)
    sum[i] -= amt[type][i];
  // not
  search(type + 1);
}

int main() {
  ifstream fin("holstein.in");
  fin >> v;
  for (int i = 0; i < v; i++)
    fin >> req[i];
  fin >> g;
  for (int i = 0; i < g; i++)
    for (int j = 0; j < v; j++)
      fin >> amt[i][j];
  fin.close();

  minCount = INT32_MAX;
  search(0);

  ofstream fout("holstein.out");
  fout << minCount;
  for (int i = 0; i < pathAns.size(); i++)
    fout << ' ' << pathAns[i] + 1;
  fout << '\n';
  fout.close();
  return 0;
}