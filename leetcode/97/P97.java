public class Solution {
  public boolean isInterleave(String s1, String s2, String s3) {
    int l1 = s1.length(), l2 = s2.length(), l3 = s3.length();
    if (l1 + l2 != l3) return false;
    boolean[][] d = new boolean[l1 + 1][l2 + 1];
    d[0][0] = true;
    for (int i = 1; i <= l1; i++)
      d[i][0] = d[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
    for (int i = 1; i <= l2; i++)
      d[0][i] = d[0][i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1);
    for (int i = 1; i <= l1; i++)
      for (int j = 1; j <= l2; j++)
        d[i][j] = s3.charAt(i + j - 1) == s1.charAt(i - 1) && d[i - 1][j] ||
            s3.charAt(i + j - 1) == s2.charAt(j - 1) && d[i][j - 1];
    return d[l1][l2];
  }
}