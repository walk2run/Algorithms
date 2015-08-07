/**
 * Created by yfy on 2015/8/5.
 * Implement strStr()
 */

class Solution {
	public int strStr(String haystack, String needle) {
		int n, m, i, q;

		n = haystack.length();
		m = needle.length();

		if (m == 0)	return 0;

		int[] next = new int[m];
		q = next[0] = 0;
		for (i = 1; i < m; i++) {
			while (q > 0 && needle.charAt(q) != needle.charAt(i))
				q = next[q - 1];
			if (needle.charAt(q) == needle.charAt(i))
				q++;
			next[i] = q;
		}

		q = 0;	// next[]
		for (i = 0; i < n; i++) {
			while (q > 0 && needle.charAt(q) != haystack.charAt(i))
				q = next[q - 1];
			if (needle.charAt(q) == haystack.charAt(i))
				q++;
			if (q == m)
				return i - m + 1;
		}

		return -1;
	}
}

public class P28 {
	public static void main(String[] args) {
		System.out.println(new Solution().strStr("", ""));
	}
}
