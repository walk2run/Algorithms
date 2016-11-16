/**
 * Created by yfy on 16-11-16.
 * String to Integer (atoi)
 */

class Solution {
  public int myAtoi(String str) {
    int state = 0;
    long n = 0;
    int sign = 1;
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (state == 0) {
        if (ch == ' ') ;
        else if (ch == '-') {
          sign = -1;
          state = 1;
        } else if (ch == '+') {
          state = 1;
        } else if (ch >= '0' && ch <= '9') {
          n = n * 10 + (ch - '0');
          state = 1;
        } else break;
      } else if (state == 1) {
        if (ch >= '0' && ch <= '9') {
          n = n * 10 + (ch - '0');
          if (n * sign > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
          if (n * sign < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        } else break;
      }
    }
    return (int)(n * sign);
  }
}

public class P8 {
}
