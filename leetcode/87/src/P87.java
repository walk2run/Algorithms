import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yfy on 2/6/16.
 * 87. Scramble String
 */

class Solution {
	public boolean isScramble(String s1, String s2) {
		this.s1 = s1;
		this.s2 = s2;
		return search(0, 0, s1.length());
	}

	boolean search(int i1, int i2, int n) {
		Tuple tuple = new Tuple(i1, i2, n);
		Boolean match = map.get(tuple);
		if (match != null) return match;
		char[] c1 = s1.substring(i1, i1 + n).toCharArray();
		char[] c2 = s2.substring(i2, i2 + n).toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		if (!Arrays.equals(c1, c2)) {
			map.put(tuple, false);
			return false;
		}
		if (n == 1) {
			map.put(tuple, true);
			return true;
		}
		for (int i = 1; i < n; i++) {
			if (search(i1, i2, i) && search(i1 + i, i2 + i, n - i) ||
					search(i1, i2 + n - i, i) && search(i1 + i, i2, n - i)) {
				map.put(tuple, true);
				return true;
			}
		}
		map.put(tuple, false);
		return false;
	}

	String s1, s2;
	Map<Tuple, Boolean> map = new HashMap<>();

	class Tuple {
		Tuple(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;

			Tuple tuple = (Tuple) o;

			if (a != tuple.a) return false;
			if (b != tuple.b) return false;
			return c == tuple.c;
		}

		@Override
		public int hashCode() {
			int result = a;
			result = 31 * result + b;
			result = 31 * result + c;
			return result;
		}

		int a, b, c;
	}
}

class Solution2 {
	public boolean isScramble(String s1, String s2) {
		int i, j, l, n, k;
		n = s1.length();
		boolean[][][] d = new boolean[n][n][n];
		for (i = 0; i < n; i++)
			for (j = 0; j < n; j++)
				d[i][j][0] = s1.charAt(i) == s2.charAt(j);
		for (l = 1; l < n; l++)
			for (i = 0; i < n - l; i++)
				for (j = 0; j < n - l; j++) {
					d[i][j][l] = false;
					for (k = 0; k < l; k++)
						if (d[i][j][k] && d[i + k + 1][j + k + 1][l - k - 1] ||
								d[i][j + l - k][k] && d[i + k + 1][j][l - k - 1]) {
							d[i][j][l] = true;
							break;
						}
				}
		return d[0][0][n - 1];
	}
}

public class P87 {
	public static void main(String[] args) {
		System.out.println(new Solution2().isScramble("great", "rgtae"));
	}
}
