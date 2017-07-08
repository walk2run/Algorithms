#include <fstream>
#include <algorithm>
using namespace std;

ifstream fin("A-large-practice.in");
ofstream fout("A-large.out");

void solve(int n, int m) {
  unsigned long long sum = 0;
  for (unsigned long long i = 1; i < std::min(n, m); i++)
    sum = (sum + (n - i) * (m - i) % 1000000007 * i) % 1000000007;
  fout << sum << '\n';
}

int main() {  
  int t, n, m;
  fin >> t;
  for (int i = 1; i <= t; i++) {
    fout << "Case #" << i << ": ";
    fin >> n >> m;
    solve(n, m);
  }
  fin.close();
  fout.close();
}
