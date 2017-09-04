// 140. Word Break II

import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<String> wordBreak(String s, List<String> wordDict) {
    int n = s.length();
    boolean[] d = new boolean[n];
    List<String>[] stss = new List[n];
    for (int i = 0; i < n; i++) {
      stss[i] = new ArrayList<>();
      for (String word : wordDict) {
        int len = word.length();
        int prev = i - len;
        if (prev < -1) continue;
        if ((prev == -1 || d[prev]) && s.substring(prev + 1, i + 1).equals(word)) {
          d[i] = true;
          if (prev == -1) {
            stss[i].add(word);
          } else {
            for (String st : stss[prev])
              stss[i].add(st + " " + word);
          }
        }
      }
    }
    return stss[n - 1];
  }
}

public class P140 {
}
