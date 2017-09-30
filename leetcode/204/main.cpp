// 204. Count Primes 
#include <iostream>

class Solution {
public:
  int countPrimes(int n) {
    bool *set = new bool[n]();
    int count = 0;
    for (int i = 2; i < n; i++) {
      if (set[i]) continue;
      count++;
      int j = i;
      while (j < n) {
        set[j] = true;
        j += i;
      }
    }
    return count;
  }
};

int main() {
  Solution().countPrimes(6);
  std::cout << "Hello, World!" << std::endl;
  return 0;
}