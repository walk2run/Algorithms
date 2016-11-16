/**
 * Created by yfy on 16-11-16.
 * Reverse Integer
 */

class Solution {
  public int reverse(int x) {
    int sign = x >= 0 ? 1 : -1;
    String st = String.valueOf(Math.abs(x));
    String re = new StringBuilder(st).reverse().toString();
    if (sign < 0) re = '-' + re;
    try {
      return Integer.parseInt(re);
    } catch (Exception e) {
      return 0;
    }
  }
}

class Solution2 {
  public int reverse(int x) {
    int sign = x >= 0 ? 1 : -1;
    x = Math.abs(x);
    long r = 0;
    while (x > 0) {
      r = r * 10 + x % 10;
      x /= 10;
    }
    r = r * sign;
    if (r < Integer.MIN_VALUE || r > Integer.MAX_VALUE)
      return 0;
    return (int)r;
  }
}

public class P7 {
}
