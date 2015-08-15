/**
 * Created by yfy on 2015/8/15.
 * Spiral Matrix II
 */

class Solution {
	public int[][] generateMatrix(int n) {
		int x0, x1, i, num;
		int[][] d = new int[n][n];
		if (n == 0) return d;
		x0 = num = 0;
		x1 = n - 1;
		while (true) {
			if (x1 - x0 > 0) {
				for (i = x0; i < x1; i++)
					d[x0][i] = ++num;
				for (i = x0; i < x1; i++)
					d[i][x1] = ++num;
				for (i = x1; i > x0; i--)
					d[x1][i] = ++num;
				for (i = x1; i > x0; i--)
					d[i][x0] = ++num;
			} else if (x1 == x0) {
				d[x0][x0] = ++num;
			} else break;
			x0++;
			x1--;
		}
		return d;
	}
}

public class P59 {
}
