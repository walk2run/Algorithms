// 164. Maximum Gap

import java.util.Arrays;

class Solution {
  public int maximumGap(int[] nums) {
    int n = nums.length;
    if (n < 2) return 0;
    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
    for (int num : nums) {
      min = Math.min(min, num);
      max = Math.max(max, num);
    }
    if (min == max) return 0;
    int gap = (int) Math.ceil((max - min) / (double) (n - 1));
    int[] mins = new int[n];
    Arrays.fill(mins, Integer.MAX_VALUE);
    int[] maxs = new int[n];
    Arrays.fill(maxs, Integer.MIN_VALUE);
    for (int num : nums) {
      int i = (num - min) / gap;
      mins[i] = Math.min(mins[i], num);
      maxs[i] = Math.max(maxs[i], num);
    }
    int ans = 0, last = maxs[0];
    for (int i = 1; i < n; i++) {
      if (mins[i] != Integer.MAX_VALUE && last != Integer.MIN_VALUE)
        ans = Math.max(ans, mins[i] - last);
      if (maxs[i] != Integer.MIN_VALUE)
        last = maxs[i];
    }
    return ans;
  }
}

public class P164 {
}
