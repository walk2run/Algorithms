#include <fstream>
#include <vector>
using namespace std;

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

  ofstream fout("lamps.out");
  fout.close();
  return 0;
}
