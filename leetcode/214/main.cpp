// 214. Shortest Palindrome
#include <iostream>
#include <algorithm>
using namespace std;

class Solution {
public:
  string shortestPalindrome(string s) {
    string rev(s);
    reverse(rev.begin(), rev.end());
    string a = s + '$' + rev;
    int *next = new int[a.length()];
    int j = next[0] = 0;
    for (int i = 1; i < a.length(); i++) {
      while (j > 0 && a[i] != a[j])
        j = next[j - 1];
      if (a[i] == a[j]) j++;
      next[i] = j;
    }
    return rev.substr(0, s.length() - next[a.length() - 1]) + s;
  }
};

int main() {
  std::cout << "Hello, World!" << std::endl;
  Solution s;
  cout << s.shortestPalindrome("aabb");
  return 0;
}