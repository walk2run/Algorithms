import java.util.Arrays;
import java.util.Collections;

/**
 * Created by yfy on 16-11-16.
 * Longest Palindromic Substring
 */

class Solution {
  public String longestPalindrome(String s) {
    int n, i, last, j, max, pos, left;

    StringBuilder sb = new StringBuilder("#");
    for (i = 0; i < s.length(); i++)
      sb.append(s.charAt(i)).append('#');
    String st = sb.toString();

    n = st.length();
    int[] d = new int[n];
    last = 0;
    for (i = 0; i < n; i++) {
      if (last > d[last] && st.charAt(i) == st.charAt(last - d[last] - 1))
        d[last]++;
      else {
        for (j = last + 1; j < i; j++) {
          d[j] = d[last - (j - last)];
          if (d[j] >= i - j - 1) {
            d[j] = i - j - 1;
            if (j > d[j] && st.charAt(i) == st.charAt(j - d[j] - 1)) {
              d[last = j]++;
              break;
            }
          }
        }
        if (j == i) last = i;
      }
    }
    max = pos = 0;
    for (i = 0; i < n; i++) {
      if (d[i] > max) {
        max = d[i];
        pos = i;
      }
    }
    left = pos / 2 - max / 2;
    return s.substring(left, left + max);
  }
}

class Solution2 {
  public String longestPalindrome(String s) {
    int i, j, n, last;
    n = s.length();

    int[] d = new int[n];  // odd
    Arrays.fill(d, 1);
    last = 0;
    for (i = 1; i < n; i++) {
      if (2 * last - i >= 0 && s.charAt(i) == s.charAt(2 * last - i))
        d[last]++;
      else {
        for (j = last + 1; j < i; j++) {
          d[j] = d[2 * last - j];
          if (d[j] > i - j) {
            d[j] = i - j;
            if (s.charAt(i) == s.charAt(j - d[j])) {
              d[last = j]++;
              break;
            }
          }
        }
        if (j == i) last = i;
      }
    }

    d = new int[n];
    last = 0;
    for (i = 1; i < n; i++) {
      
    }
  }
}

public class P5 {
  public static void main(String[] args) {
    System.out.println(new Solution().longestPalindrome("cbbd"));
  }
}
