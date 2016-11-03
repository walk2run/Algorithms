import java.util.Arrays;

/**
 * Created by yfy on 2016/11/2.
 * Longest Substring Without Repeating Characters
 * O(n)
 * Let us talk about the linear time solution now. This solution uses extra space to store the last indexes of already visited characters. The idea is to scan the string from left to right, keep track of the maximum length Non-Repeating Character Substring (NRCS) seen so far. Let the maximum length be max_len. When we traverse the string, we also keep track of length of the current NRCS using cur_len variable. For every new character, we look for it in already processed part of the string (A temp array called visited[] is used for this purpose). If it is not present, then we increase the cur_len by 1. If present, then there are two cases:
 * a) The previous instance of character is not part of current NRCS (The NRCS which is under process). In this case, we need to simply increase cur_len by 1.
 * b) If the previous instance is part of the current NRCS, then our current NRCS changes. It becomes the substring staring from the next character of previous instance to currently scanned character. We also need to compare cur_len and max_len, before changing current NRCS (or changing cur_len).
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
