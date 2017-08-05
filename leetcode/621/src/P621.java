import java.util.HashMap;
import java.util.Map;

/**
 * Created by yfy on 8/5/17.
 * 621. Task Scheduler
 */

class Solution {
  public int leastInterval(char[] tasks, int n) {
    Map<Character, Integer> map = new HashMap<>();
    int count = 0;
    for (char ch : tasks) {
      int value = map.getOrDefault(ch, 0) + 1;
      map.put(ch, value);
      count = Math.max(count, value);
    }
    int ans = (n + 1) * (count - 1);
    for (int t : map.values())
      if (t == count) ans++;
    return Math.max(ans, tasks.length);
  }
}

class Solution {
  public int leastInterval(char[] tasks, int n) {
    int[] list = new int[26];
    int count = 0;
    for (char ch : tasks) {
      list[ch - 'A']++;
      count = Math.max(count, list[ch - 'A']);
    }
    int ans = (n + 1) * (count - 1);
    for (int t : list)
      if (t == count) ans++;
    return Math.max(ans, tasks.length);
  }
}

public class P621 {
}
