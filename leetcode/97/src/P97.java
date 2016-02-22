/**
 * Created by qwordy on 2/22/16.
 * 97. Interleaving String
 */

class Solution {
	public boolean isInterleave(String s1, String s2, String s3) {
		int n, m, i, j;
		n = s1.length();
		m = s2.length();
		if (n + m != s3.length())
			return false;
		boolean[][] d = new boolean[n + 1][m + 1];
		d[0][0] = true;
		for (i = 1; i <= n && d[i - 1][0]; i++)
			d[i][0] = s1.charAt(i - 1) == s3.charAt(i - 1);
		for (j = 1; j <= m && d[0][j - 1]; j++)
			d[0][j] = s2.charAt(j - 1) == s3.charAt(j - 1);
		for (i = 1; i <= n; i++)
			for (j = 1; j <= m; j++)
				d[i][j] = d[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)
						|| d[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
		return d[n][m];
	}
}

public class P97 {
}
