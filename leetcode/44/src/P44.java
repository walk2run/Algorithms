/**
 * Created by yfy on 10/11/16.
 */

class Solution {

  private String s, p;

  private int ls, lp;

  private int[][] d;

  public boolean isMatch(String s, String p) {
    this.s = s;
    this.p = p;
    ls = s.length();
    lp = p.length();
    d = new int[ls + 1][lp + 1];
    return match(0, 0);
  }

  private boolean match(int i, int j) {
    if (d[i][j] != 0) return d[i][j] > 0;
    if (i == ls && j == lp) return true;
    if (j == lp) return false;
    if (i < ls && p.charAt(j) == '?') {
      boolean b = match(i + 1, j + 1);
      d[i][j] = b ? 1 
    }
    if (p.charAt(j) != '*')
      return i < ls && s.charAt(i) == p.charAt(j) && match(i + 1, j + 1);
    if (j < lp - 1 && p.charAt(j + 1) == '*')
      return match(i, j + 1);
    while (i <= ls)
      if (match(i++, j + 1)) return true;
    return false;
  }
}

//    return i == ls && j == lp ||
//        j < lp && i <= ls && p.charAt(j) == '*' &&
//            (match(i, j + 1) || match(i + 1, j)) ||
//        j < lp && i < ls && p.charAt(j) == '?' && match(i + 1, j + 1) ||
//        j < lp && i < ls && p.charAt(j) == s.charAt(i) && match(i + 1, j + 1);

public class P44 {
}
