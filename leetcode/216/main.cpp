// 216. Combination Sum III
#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
  vector<vector<int>> combinationSum3(int k, int n) {
    this->k = k;
    this->n = n;
    dfs(0, 1, 0);
    return vecs;
  }

  int k, n;
  vector<vector<int>> vecs;
  vector<int> vec;

  void dfs(int d, int num, int sum) {
    if (d == k) {
      if (sum == n) vecs.push_back(vec);
      return;
    }
    if (sum > n) return;
    for (int i = num; i <= 9; i++) {
      vec.push_back(i);
      dfs(d + 1, i + 1, sum + i);
      vec.pop_back();
    }
  }
};

int main() {
  std::cout << "Hello, World!" << std::endl;
  return 0;
}