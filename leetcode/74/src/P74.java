/**
 * Created by yfy on 10/30/15.
 * Search a 2D Matrix
 */

class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		int n, m, l, r, mid, val;
		n = matrix.length;
		m = matrix[0].length;
		l = 0;
		r = m * n - 1;
		while (l <= r) {
			mid = (l + r) / 2;
			val = matrix[mid / m][mid % m];
			if (val < target)
				l = mid + 1;
			else if (val == target)
				return true;
			else
				r = mid - 1;
		}
		return false;
	}
}

public class P74 {
}
