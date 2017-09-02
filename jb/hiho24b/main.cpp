#include <iostream>
#include <vector>
using namespace std;

int main() {
  int n, m, i;
  vector<int> vec;

  cin >> n >> m;
  for (i = 0; i < n; i++) {
    int a;
    cin >> a;
    if (a == 0) vec.push_back(i);
  }
  if (vec.size() < m) {
    cout << "-1\n";
    return 0;
  }
  int len = vec.size();
  for (i = 0; i < len; i++)
    vec.push_back(vec[i] + n);
  for (i = 0; i < len; i++)
    vec.push_back(vec[i] + n + n);
  long min = INT64_MAX;
  for (int i = len - m + 1; i < len * 2; i++) {
    int ii = i;
    int jj = i + m - 1;
    long sum = 0;
    while (ii < jj) {
      sum += vec[jj] - vec[ii];
      ii++;
      jj--;
    }
    if (sum < min) min = sum;
  }
  cout << min << '\n';
  return 0;
}