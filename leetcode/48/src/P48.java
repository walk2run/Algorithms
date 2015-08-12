import java.util.Arrays;

/**
 * Created by yfy on 2015/8/11.
 * Rotate Image
 */

class Solution {
	public void rotate(int[][] matrix) {
		int i, j, n, t;
		n = matrix.length;
		for (i = 0; i < n; i++)
			for (j = 0; j < i; j++) {
				t = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = t;
			}
		for (j = 0; j < n / 2; j++)
			for (i = 0; i < n; i++) {
				t = matrix[i][j];
				matrix[i][j] = matrix[i][n - 1 - j];
				matrix[i][n - 1 - j] = t;
			}
	}
}

public class P48 {
	public static void main(String[] args) {
		int[][] m = new int[][]{{1, 2}, {3, 4}};
		new Solution().rotate(m);
	}
}
