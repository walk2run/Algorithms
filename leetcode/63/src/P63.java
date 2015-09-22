/**
 * Created by yfy on 9/22/15.
 * Unique Paths II
 */

class Solution {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int i, j, n, m;
		n = obstacleGrid.length;
		m = obstacleGrid[0].length;
		int[][] d = new int[n][m];
		for (i = 0; i < n && obstacleGrid[i][0] == 0; i++)
			d[i][0] = 1;
		for (j = 0; j < m && obstacleGrid[0][j] == 0; j++)
			d[0][j] = 1;
		for (i = 1; i < n; i++)
			for (j = 1; j < m; j++)
				if (obstacleGrid[i][j] == 1)
					d[i][j] = 0;
				else
					d[i][j] = d[i - 1][j] + d[i][j - 1];
		return d[n - 1][m - 1];
	}
}

public class P63 {
}
