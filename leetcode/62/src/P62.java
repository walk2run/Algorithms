/**
 * Created by yfy on 9/16/15.
 * Unique Paths
 */

class Solution {
	public int uniquePaths(int m, int n) {
		int i, j;
		int[][] d = new int[m][n];
		for (i = 0; i < m; i++)
			d[i][0] = 1;
		for (i = 0; i < n; i++)
			d[0][i] = 1;
		for (i = 1; i < m; i++)
			for (j = 1; j < n; j++)
				d[i][j] = d[i - 1][j] + d[i][j - 1];
		return d[m - 1][n - 1];
	}
}

public class P62 {
}
