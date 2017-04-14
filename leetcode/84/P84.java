public class Solution {
  public int largestRectangleArea(int[] heights) {
    int n = heights.length;
    int[] h = new int[n + 1];
    System.arraycopy(heights, 0, h, 0, n);
    h[n] = 0;
    int[] s = new int[h.length];
    int t = -1, max = 0;
    for (int i = 0; i < h.length;) {
      if (t < 0 || h[i] >= h[s[t]]) {
        s[++t] = i++;
      } else {
        int top = h[s[t--]];
        max = Math.max(max, top * (t < 0 ? i : i - s[t] - 1));
      }
    }
    return max;
  }
}