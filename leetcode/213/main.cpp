// 213. House Robber II
#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
  int rob(vector<int>& nums) {
    if (nums.empty()) return 0;
    if (nums.size() == 1) return nums[0];
    int a = 0, b = -1, c, d;
    for (int i = 1; i < nums.size(); i++) {
      c = std::max(a, b);
      d = a + nums[i];
      a = c;
      b = d;
    }
    int max = std::max(a, b);
    a = INT32_MIN;
    b = nums[0];
    for (int i = 1; i < nums.size(); i++) {
      c = std::max(a, b);
      d = a + nums[i];
      a = c;
      b = d;
    }
    return std::max(max, a);
  }
};

int main() {
  std::cout << "Hello, World!" << std::endl;
  return 0;
}