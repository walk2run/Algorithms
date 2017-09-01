#include <iostream>
using namespace std;

int main() {
  int n, i, q, x, y, u, v;
  int a[100000];
  cin >> n;
  for (i = 0; i < n; i++)
    cin >> a[i];
  cin >> q;
  for (i = 0; i < q; i++) {
    cin >> x;
    if (x == 1) {
      cin >> y;
      y--;
      int count = 0;
      while (y < n) {
        count++;
        y += a[y];
      }
      cout << count << '\n';
    } else {
      cin >> u >> v;
      u--;
      a[u] = v;
    }
  }
  return 0;
}