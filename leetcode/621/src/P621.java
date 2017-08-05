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
      map.put(ch, map.getOrDefault(ch, 0) + 1);
      count = Math.max(count, map.get(ch));
    }
    int ans = (n + 1) * (count - 1);
    for (int t : map.values())
      if (t == count) ans++;
    return Math.max(ans, tasks.length);
  }
}

public class P621 {
}
