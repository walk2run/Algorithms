public class Solution {
  public int numDecodings(String s) {
    int n = s.length();
    if (n == 0) return 0;
    int[] d = new int[n];
    for (int i = 0; i < n; i++) {
      int num = s.charAt(i) - '0';
      if (num > 0) d[i] = i == 0 ? 1 : d[i - 1];
      if (i > 0) {
        int lastNum = s.charAt(i - 1) - '0';
        int val = lastNum * 10 + num;
        if (val >= 10 && val <= 26)
          d[i] += i - 2 >= 0 ? d[i - 2] : 1;
      }
    }
    return d[n - 1];
  }
}