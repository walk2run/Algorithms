/**
 * Created by yfy on 16-11-16.
 * Palindrome Number
 */

class Solution {
  public boolean isPalindrome(int x) {
    long a, left, right;
    if (x < 0) return false;
    if (x == 0) return true;
    a = 1;
    while (a <= x) a *= 10;
    a /= 10;
    while (x > 0) {
      left = x / a;
      right = x % 10;
      if (left != right) return false;
      x = (int) (x % a / 10);
      a /= 100;
    }
    return true;
  }
}

public class P9 {
}
