#include <iostream>
using namespace std;

int n, k;
int a[10];

void dfs(int d) {
  if (d == n) {
    for (int i = 0; i < n; i++)
      cout << a[i];
    cout << '\n';
  } else {
    int start = 0;
    if (d == 0) start = 1;
    for (int i = start; i <= k; i++) {
      if (d == 0 || a[d - 1] * i <= k) {
        a[d] = i;
        dfs(d + 1);
      }
    }
  }
}

int main() {
  cin >> n >> k;
  dfs(0);
  return 0;
}