// 166. Fraction to Recurring Decimal

import java.util.HashMap;
import java.util.Map;

class Solution {
  public String fractionToDecimal(int numerator, int denominator) {
    long n = numerator < 0 ? -(long)numerator : numerator;
    long d = denominator < 0 ? -(long)denominator : denominator;
    boolean neg = false;
    if (numerator < 0) neg = !neg;
    if (denominator < 0) neg = !neg;
    long r = n % d;
    long q = n / d;
    StringBuilder sb = new StringBuilder("" + q);
    if (r == 0) return format(neg, sb);
    sb.append('.');
    Map<Long, Integer> map = new HashMap<>();
    while (true) {
      q = r * 10 / d;
      long rr = r * 10 % d;
      Integer pos = map.get(rr);
      if (pos != null) {
        if (sb.charAt(pos) - '0' != q) sb.append(q);
        sb.insert(pos, "(");
        sb.append(')');
        break;
      }
      map.put(r, sb.length());
      sb.append(q);
      if (rr == 0) break;
      r = rr;
    }
    return format(neg, sb);
  }

  String format(boolean neg, StringBuilder sb) {
    if (neg && !sb.toString().equals("0")) sb.insert(0, '-');
    return sb.toString();
  }
}

public class P166 {
  public static void main(String[] args) {
    System.out.println(new Solution().fractionToDecimal(-2147483648, 1));
  }
}
