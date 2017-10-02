// 209. Minimum Size Subarray Sum
#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
  int minSubArrayLen(int s, vector<int>& nums) {
    int i = 0, j = -1, sum = 0, min = INT32_MAX;
    while (1) {
      if (sum < s) {
        if (j == nums.size() - 1) break;
        sum += nums[++j];
      } else {
        min = std::min(min, j - i + 1);
        sum -= nums[i++];
      }
    }
    return min == INT32_MAX ? 0 : min;
  }
};

int main() {
  std::cout << "Hello, World!" << std::endl;
  return 0;
}