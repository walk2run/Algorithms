public class Solution {
  public int minimumTotal(List<List<Integer>> triangle) {
    int n = triangle.size();
    int[] d = new int[n];
    for (int i = 0; i < n; i++)
      d[i] = triangle.get(n - 1).get(i);
    for (int i = n - 2; i >= 0; i--)
      for (int j = 0; j <= i; j++)
        d[j] = triangle.get(i).get(j) + Math.min(d[j], d[j + 1]);
    return d[0];
  }
}