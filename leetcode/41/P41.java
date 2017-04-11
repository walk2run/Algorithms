class Solution {
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

class Solution {
  public int firstMissingPositive(int[] nums) {
    int[] a = nums;
    int n = a.length;
    for (int i = 0; i < n; i++)
      if (a[i] <= 0 || a[i] > n) a[i] = n + 1;
    for (int i = 0; i < n; i++) {
      if (Math.abs(a[i]) <= n) {
        int j = Math.abs(a[i]) - 1;
        if (a[j] > 0) a[j] = -a[j];
      }
    }
    int i;
    for (i = 0; i < n && a[i] < 0; i++);
    return i + 1;
  }
}