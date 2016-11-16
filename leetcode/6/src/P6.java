import java.util.ArrayList;

/**
 * Created by yfy on 16-11-16.
 * ZigZag Conversion
 */

class Solution {
  public String convert(String s, int numRows) {
    int step, i, j, n;
    n = s.length();
    StringBuilder t = new StringBuilder();
    step = (numRows - 1) * 2;
    if (step == 0) step = 1;
    for (i = 0; i < numRows; i++) {
      j = i;
      if (i == 0 || i == numRows - 1) {
        while (j < n) {
          t.append(s.charAt(j));
          j += step;
        }
      } else {
        while (j < n) {
          t.append(s.charAt(j));
          j += step - i * 2;
          if (j < n)
            t.append(s.charAt(j));
          j += i * 2;
        }
      }
    }
    return t.toString();
  }
}

public class P6 {
}
