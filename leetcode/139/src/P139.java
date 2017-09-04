// 139. Word Break

import java.util.List;

class Solution {
  public boolean wordBreak(String s, List<String> wordDict) {
    int n = s.length();
    boolean[] d = new boolean[n];
    for (int i = 0; i < n; i++) {
      for (String word : wordDict) {
        int len = word.length();
        if (i - len < -1) continue;
        if ((i - len == -1 || d[i - len]) && s.substring(i - len + 1, i + 1).equals(word)) {
          d[i] = true;
          break;
        }
      }
    }
    return d[n - 1];
  }
}

public class P139 {
}
