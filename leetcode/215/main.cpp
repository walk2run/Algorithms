// 215. Kth Largest Element in an Array
#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
  int findKthLargest(vector<int> &nums, int k) {
    return qsort(nums, k, 0, nums.size() - 1);
  }

  int qsort(vector<int> &nums, int k, int l, int r) {
    if (l == r) return nums[l];
    int i = l, j = r, m = (l + r) / 2;
    int v = nums[m];
    while (i <= j) {
      while (nums[i] > v) i++;
      while (nums[j] < v) j--;
      if (i <= j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
        i++;
        j--;
      }
    }
    if (l <= j && k <= j - l + 1)
      return qsort(nums, k, l, j);
    if (i <= r && k > i - l)
      return qsort(nums, k - i + l, i, r);
    return nums[j + 1];
  }
};

int main() {
  std::cout << "Hello, World!" << std::endl;
  return 0;
}