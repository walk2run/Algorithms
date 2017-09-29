// 187. Repeated DNA Sequences
#include <iostream>
#include <vector>
#include <string>
#include <unordered_set>
using namespace std;

class Solution {
public:
  vector<string> findRepeatedDnaSequences(string s) {
    unordered_set<string> set, set2;
    string a = s.substr(0, 10);
    set.insert(a);
    vector<string> vec;
    for (int i = 10; i < s.length(); i++) {
      a.erase(0, 1);
      a.push_back(s[i]);
      if (set.count(a) > 0) {
        if (set2.count(a) == 0) {
          vec.push_back(a);
          set2.insert(a);
        }
      } else {
        set.insert(a);
      }
    }
    return vec;
  }
};

int main() {
  Solution().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
  return 0;
}