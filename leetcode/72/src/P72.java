/**
 * Created by yfy on 9/29/15.
 * Edit Distance
 */

class Solution {
	public int minDistance(String word1, String word2) {
		int i, j, n, m;
		n = word1.length();
		m = word2.length();
		if (n == 0) return m;
		if (m == 0) return n;
		int d[][] = new int[n][m];
		d[0][0] = word1.charAt(0) == word2.charAt(0) ? 0 : 1;
		for (i = 1; i < m; i++)
			if (word1.charAt(0) == word2.charAt(i))
				d[0][i] = i;
			else
				d[0][i] = d[0][i - 1] + 1;
		for (i = 1; i < n; i++)
			if (word1.charAt(i) == word2.charAt(0))
				d[i][0] = i;
			else
				d[i][0] = d[i - 1][0] + 1;
		for (i = 1; i < n; i++)
			for (j = 1; j < m; j++)
				if (word1.charAt(i) == word2.charAt(j))
					d[i][j] = d[i - 1][j - 1];
				else
					d[i][j] = Math.min(Math.min(d[i - 1][j], d[i][j - 1]), d[i - 1][j - 1]) + 1;
		return d[n - 1][m - 1];
	}
}

public class P72 {
}
