// 189. Rotate Array
#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
  void rotate(vector<int>& nums, int k) {
    if (k == 0) return;
    vector<int> vec(nums);
    int n = nums.size();
    for (int i = 0; i < n; i++)
      nums[(i + k) % n] = vec[i];
  }
};

int main() {
  std::cout << "Hello, World!" << std::endl;
  return 0;
}