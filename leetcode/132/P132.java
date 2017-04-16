public class Solution {
  public int minCut(String s) {
    int n = s.length();
    int[] d = new int[n];
    Arrays.fill(d, Integer.MAX_VALUE);
    d[0] = 0;
    boolean[][] p = new boolean[n][n];
    //for (int i = 0; i < n; i++) p[i][i] = true;
    for (int i = 1; i < n; i++) {
      if (s.charAt(0) == s.charAt(i) && (i < 3 || p[1][i - 1])) {
        d[i] = 0;
        continue;
      }
      for (int j = 0; j < i; j++) {
        if ((i - j <= 3 || p[j + 2][i - 1]) && s.charAt(j + 1) == s.charAt(i)) {
          d[i] = Math.min(d[i], d[j] + 1);
          p[j + 1][i] = true;
        }
      }
    }
    return d[n - 1];
  }
}