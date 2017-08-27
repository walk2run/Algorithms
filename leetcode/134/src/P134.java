/**
 * Created by yfy on 8/22/17.
 * 134. Gas Station
 */

class Solution {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int n = gas.length;
    int[] a = new int[n];
    for (int i = 0; i < n; i++)
      a[i] = gas[i] - cost[i];
    int sum = a[0], l = 0, r = 0, count = 0;
    while (count < n - 1) {
      if (sum >= 0) {
        r++;
        sum += a[r];
      } else {
        if (l == 0) l = n;
        l--;
        sum += a[l];
      }
      count++;
    }
    if (sum >= 0) return l % n;
    return -1;
  }
}

public class P134 {
}
