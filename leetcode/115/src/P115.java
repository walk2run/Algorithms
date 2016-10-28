/**
 * Created by qwordy on 2/26/16.
 * 115. Distinct Subsequences
 */

class Solution {
  public int numDistinct(String s, String t) {
    int i, j, slen, tlen;
    slen = s.length();
    tlen = t.length();
    if (tlen == 0) return 1;
    if (slen == 0) return 0;
    int d[][] = new int[slen][tlen];
    //d[i][j] = d[i-1][j] + (if d[i]==d[j])d[i-1][j-1]
    if (s.charAt(0) == t.charAt(0)) d[0][0] = 1;
    for (i = 1; i < slen; i++) {
      d[i][0] = d[i - 1][0];
      if (s.charAt(i) == t.charAt(0)) d[i][0]++;
      for (j = 1; j <= Math.min(i, tlen - 1); j++) {
        d[i][j] = d[i - 1][j];
        if (s.charAt(i) == t.charAt(j)) d[i][j] += d[i - 1][j - 1];
      }
    }
    return d[slen - 1][tlen - 1];
  }
}

public class P115 {
}
