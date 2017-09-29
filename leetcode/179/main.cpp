// 179. Largest Number
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

struct {
  bool operator()(string a, string b) {
    return a > b;
  }
} comp;

class Solution {
public:
  string largestNumber(vector<int>& nums) {
    vector<string> vec;
    for (int num : nums)
      vec.push_back(to_string(num));
    sort(vec.begin(), vec.end(), [](string &a, string &b){return a + b > b + a;});
    string ans;
    for (string str : vec)
      ans.append(str);
    while (ans.length() > 1 && ans[0] == '0')
      ans.erase(0, 1);
    return ans;
  }
};

int main() {
  vector<int> nums = {11, 5, 8};
  Solution().largestNumber(nums);
  return 0;
}