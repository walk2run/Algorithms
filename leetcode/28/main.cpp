// 28. Implement strStr()
#include <iostream>
using namespace std;

class Solution {
public:
  int strStr(string haystack, string needle) {
    if (needle.empty()) return 0;
    int n = haystack.length(), m = needle.length();
    int *next = new int[m];
    int q = *next = 0;
    for (int i = 1; i < m; i++) {
      while (q > 0 && needle[q] != needle[i])
        q = next[q - 1];
      if (needle[q] == needle[i])
        q++;
      next[i] = q;
    }
    q = 0;
    for (int i = 0; i < n; i++) {
      while (q > 0 && needle[q] != haystack[i])
        q = next[q - 1];
      if (needle[q] == haystack[i])
        q++;
      if (q == needle.length())
        return i - m + 1;
    }
    return -1;
  }
};

class Solution {
public:
  int strStr(string haystack, string needle) {
    int n = haystack.length(), m = needle.length();
    for (int i = 0; i <= n - m; i++) {
      int j;
      for (j = 0; j < m; j++)
        if (needle[j] != haystack[i + j]) break;
      if (j == m) return i;
    }
    return -1;
  }
};

int main() {
  std::cout << "Hello, World!" << std::endl;
  return 0;
}