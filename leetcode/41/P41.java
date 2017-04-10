public class Solution {
  public int firstMissingPositive(int[] nums) {
    int[] a = nums;
    int n = a.length;
    for (int i = 0; i < n; i++) {
      while (a[i] != -1 && a[i] != i + 1) {
        int j = a[i] - 1;
        if (a[i] < 1 || a[i] > n || a[i] == a[j])
          a[i] = -1;
        else {
          int t = a[j];
          a[j] = a[i];
          a[i] = t;
        }
      }
    }
    int i = 0;
    for (i = 0; i < n && a[i] == i + 1; i++);
    return i + 1;
  }
}