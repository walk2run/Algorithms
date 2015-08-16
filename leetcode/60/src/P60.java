/**
 * Created by yfy on 2015/8/15.
 * Permutation Sequence
 */

class Solution {
	public String getPermutation(int n, int k) {
		int i, rest, count, j, c;
		int[] cs = new int[n + 1];
		cs[0] = 1;
		for (i = 1; i <= n; i++)
			cs[i] = cs[i - 1] * i;

		StringBuilder st = new StringBuilder();
		boolean[] use = new boolean[n + 1];
		rest = k - 1;
		for (i = 0; i < n; i++) {
			count = rest / cs[n - i - 1] + 1;
			c = 0;
			for (j = 1; j <= n; j++) {
				if (!use[j])
					if (++c == count) {
						use[j] = true;
						st.append((char) (j + '0'));
						break;
					}
			}
			rest = rest % cs[n - i - 1];
		}
		return st.toString();
	}
}

public class P60 {
	public static void main(String[] args) {
		System.out.println(new Solution().getPermutation(2, 2));
	}

}
