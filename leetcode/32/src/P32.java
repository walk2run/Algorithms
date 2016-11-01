// f[i] represents the maximal length of valid parentheses which ends with s[i]
class Solution {
	public int longestValidParentheses(String s) {
		if (s.length() == 0) return 0;
		int[] f = new int[s.length()];
		f[0] = 0;
		for (int i = 1; i < s.length(); i++) {
			int t = i - 1 - f[i - 1];
			if (s.charAt(i) == ')') {
				if (t < 0)
					f[i] = 0;
				else if (s.charAt(t) == '(') {
					f[i] = f[i - 1] + 2;
					if (t > 0) f[i] += f[t - 1];
				}
			} else {
				f[i] = 0;
			}
		}
		int max = 0;
		for (int x : f) {
			//System.out.print(x + " ");
			if (x > max) max = x;
		}
		return max;
	}
}

public class P32 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Solution().longestValidParentheses("())((())");
	}

}
