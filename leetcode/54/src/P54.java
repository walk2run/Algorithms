import java.util.ArrayList;
import java.util.List;

/**
 * Created by yfy on 2015/8/13.
 * Spiral Matrix
 */

class Solution {
	public List<Integer> spiralOrder(int[][] matrix) {
		int n, m, x0, y0, x1, y1, i;
		List<Integer> list = new ArrayList<>();
		n = matrix.length;
		if (n == 0) return list;
		m = matrix[0].length;
		if (m == 0) return list;
		x0 = y0 = 0;
		x1 = n - 1;
		y1 = m - 1;
		while (true) {
			if (x1 - x0 > 0 && y1 - y0 > 0) {
				for (i = y0; i < y1; i++)
					list.add(matrix[x0][i]);
				for (i = x0; i < x1; i++)
					list.add(matrix[i][y1]);
				for (i = y1; i > y0; i--)
					list.add(matrix[x1][i]);
				for (i = x1; i > x0; i--)
					list.add(matrix[i][y0]);
			} else if (x1 == x0) {
				for (i = y0; i <= y1; i++)
					list.add(matrix[x0][i]);
			} else if (y1 == y0) {
				for (i = x0; i <= x1; i++)
					list.add(matrix[i][y0]);
			} else break;
			x0++;
			y0++;
			x1--;
			y1--;
		}
		return list;
	}
}

public class P54 {
	public static void main(String[] args) {
		System.out.println(new Solution().spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
	}
}
