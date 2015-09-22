/**
 * Created by yfy on 9/22/15.
 * Minimum Path Sum
 */

class Solution {
	public int minPathSum(int[][] grid) {
		int n, m, i, j;
		n = grid.length;
		m = grid[0].length;
		int[][] d = new int[n][m];
		d[0][0] = grid[0][0];
		for (i = 1; i < n; i++)
			d[i][0] = d[i - 1][0] + grid[i][0];
		for (j = 1; j < m; j++)
			d[0][j] = d[0][j - 1] + grid[0][j];
		for (i = 1; i < n; i++)
			for (j = 1; j < m; j++)
				d[i][j] = Math.min(d[i - 1][j], d[i][j - 1]) + grid[i][j];
		return d[n - 1][m - 1];
	}
}

public class P64 {
}
