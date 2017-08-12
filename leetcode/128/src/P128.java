import java.util.HashMap;
import java.util.Map;

/**
 * Created by yfy on 8/12/17.
 * 128. Longest Consecutive Sequence
 */

class Solution {
  public int longestConsecutive(int[] nums) {
    Map<Integer, Boolean> map = new HashMap<>();
    int max = 0;
    for (int num : nums) map.put(num, false);
    for (int num : nums) {
      if (map.get(num)) continue;
      int i = num;
      while (map.containsKey(++i)) map.put(i, true);
      int j = num;
      while (map.containsKey(--j)) map.put(j, true);
      max = Math.max(max, i - j - 1);
    }
    return max;
  }
}

public class P128 {
}
