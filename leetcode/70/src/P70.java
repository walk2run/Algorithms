/**
 * Created by yfy on 9/29/15.
 * Climbing Stairs
 */

class Solution {
	public int climbStairs(int n) {
		int[] d = new int[n + 1];
		d[0] = d[1] = 1;
		for (int i = 2; i <= n; i++)
			d[i] = d[i - 1] + d[i - 2];
		return d[n];
	}
}

public class P70 {
}
