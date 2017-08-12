import java.util.ArrayList;
import java.util.List;

/**
 * Created by yfy on 8/12/17.
 * 131. Palindrome Partitioning
 */

public class Solution {
  public List<List<String>> partition(String s) {
    this.s = s;
    dfs(0);
    return lists;
  }

  String s;
  List<List<String>> lists = new ArrayList<>();
  List<String> list = new ArrayList<>();

  void dfs(int p) {
    if (p == s.length()) {
      lists.add(new ArrayList<>(list));
      return;
    }
    for (int i = p; i < s.length(); i++) {
      if (palindrome(p, i)) {
        list.add(s.substring(p, i + 1));
        dfs(i + 1);
        list.remove(list.size() - 1);
      }
    }
  }

  boolean palindrome(int a, int b) {
    for (int i = a; i <= (a + b) / 2; i++)
      if (s.charAt(i) != s.charAt(b - i + a))
        return false;
    return true;
  }
}

public class P131 {
}
