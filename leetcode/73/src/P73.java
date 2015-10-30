/**
 * Created by yfy on 10/27/15.
 * Set Matrix Zeroes
 */

class Solution {
	public void setZeroes(int[][] matrix) {
		int n, m, i, j, row, col;
		n = matrix.length;
		m = matrix[0].length;
		row = col = -1;
		for (i = 0; i < n; i++)
			for (j = 0; j < m; j++)
				if (matrix[i][j] == 0) {
					if (row == -1) {
						row = i;
						col = j;
					} else {
						matrix[i][col] = 0;
						matrix[row][j] = 0;
					}
				}
		if (row == -1) return;
		for (i = 0; i < n; i++) {
			if (i == row) continue;
			for (j = 0; j < m; j++) {
				if (j == col) continue;
				if (matrix[i][col] == 0 || matrix[row][j] == 0)
					matrix[i][j] = 0;
			}
		}
		for (i = 0; i < n; i++)
			matrix[i][col] = 0;
		for (j = 0; j < m; j++)
			matrix[row][j] = 0;
	}
}

public class P73 {
}
