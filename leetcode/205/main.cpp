// 205. Isomorphic Strings
#include <iostream>
#include <string>
#include <unordered_map>
using namespace std;

class Solution {
public:
  bool isIsomorphic(string s, string t) {
    unordered_map<char, char> map1, map2;
    if (s.length() != t.length()) return false;
    for (int i = 0; i < s.length(); i++) {
      auto it1 = map1.find(s[i]);
      auto it2 = map2.find(t[i]);
      if (it1 != map1.end() && it1->second != t[i]) return false;
      if (it2 != map2.end() && it2->second != s[i]) return false;
      map1[s[i]] = t[i];
      map2[t[i]] = s[i];
    }
    return true;
  }
};

int main() {
  std::cout << "Hello, World!" << std::endl;
  return 0;
}