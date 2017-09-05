// 140. Word Break II

import java.util.ArrayList;
import java.util.List;

class Solution {
  public List<String> wordBreak(String s, List<String> wordDict) {
    this.s = s;
    int n = s.length();
    boolean[] d = new boolean[n];
    prevs = new List[n];
    for (int i = 0; i < n; i++) {
      prevs[i] = new ArrayList<>();
      for (String word : wordDict) {
        int len = word.length();
        int prev = i - len;
        if (prev < -1) continue;
        if ((prev == -1 || d[prev]) && s.substring(prev + 1, i + 1).equals(word)) {
          d[i] = true;
          prevs[i].add(prev);
        }
      }
    }
    ans = new ArrayList<>();
    output(n - 1, "");
    return ans;
  }

  String s;
  List<Integer>[] prevs;
  List<String> ans;

  void output(int d, String str) {
    for (int prev : prevs[d]) {
      String word = s.substring(prev + 1, d + 1);
      if (prev == -1)
        ans.add(word + str);
      else
        output(prev, " " + word + str);
    }
  }
}

public class P140 {
}
