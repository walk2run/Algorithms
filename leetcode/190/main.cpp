// 190. Reverse Bits
#include <iostream>

class Solution {
public:
  uint32_t reverseBits(uint32_t n) {
    uint32_t a = 0;
    for (int i = 31; i >= 0 ; i--) {
      a |= (n & 1) << i;
      n >>= 1;
    }
    return a;
  }
};

int main() {
  std::cout << "Hello, World!" << std::endl;
  return 0;
}