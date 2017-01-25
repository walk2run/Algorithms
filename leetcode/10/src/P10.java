/**
 * Created by yfy on 2017/1/19.
 * Regular Expression Matching
 */

// Recursive version
class Solution {
  private String s, p;

  public boolean isMatch(String s, String p) {
    this.s = s;
    this.p = p;
    return match(0, 0);
  }

  private boolean match(int i, int j) {
    if (i == s.length() && j == p.length()) return true;
    if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
      if (match(i, j + 2)) return true;
      while (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
        if (match(i + 1, j + 2)) return true;
        i++;
      }
      return false;
    }
    if (i >= s.length() || j >= p.length()) return false;
    if (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j))
      return match(i + 1, j + 1);
    return false;
  }
}

class Solution2 {
  public boolean isMatch(String s, String p) {
    int i, j;
    i = j = 0;
    while (i < s.length()) {
      if (j < p.length() && (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i))) {
        i++;
        j++;
      }
    }
  }
}

public class P10 {
  public static void main(String[] args) {
    System.out.println(new Solution().isMatch("aa", "a*"));
  }
}
