import java.util.Arrays;

/**
 * Created by yfy on 2016/11/2.
 * Longest Substring Without Repeating Characters
 * O(n)
 */

class Solution {
  public int lengthOfLongestSubstring(String s) {
    int i, j, max;
    int[] d = new int[256];  // nearest position of each character
    Arrays.fill(d, -1);
    i = max = 0;
    for (j = 0; j < s.length(); j++) {
      if (d[s.charAt(j)] >= i) i = d[s.charAt(j)] + 1;
      d[s.charAt(j)] = j;
      max = Math.max(max, j - i + 1);
    }
    return max;
  }
}

public class P3 {
}
