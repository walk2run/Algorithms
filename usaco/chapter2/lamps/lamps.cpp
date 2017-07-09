#include <fstream>
#include <vector>
#include <cstring>
using namespace std;

const int N = 100;

int main() {
  int n, c, id;
  vector<int> ons, offs;
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

  bool ao[N + 1];
  memset(ao, 1, sizeof(ao));
  bool af[N + 1];
  memset(af, 0, sizeof(af));
  bool eoof[N + 1];
  for (int i = 2; i <= N; i += 2)
    eoof[i] = 1;
  bool efoo[N + 1];
  for (int i = 1; i <= n; i += 2)
    efoo[i] = 1;
  bool ko[N + 1];
  for (int i = 1; i <= n; i++)
    ko[i] = i % 3 == 1 ? 1 : 0;
  bool kf[N + 1];
  for (int i = 1; i <= n; i++)
    kf[i] = i % 3 == 1 ? 0 : 1;
  

  if (c == 0) {

  }

  ofstream fout("lamps.out");
  fout.close();
  return 0;
}
