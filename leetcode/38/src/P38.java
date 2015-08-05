/**
 * Created by yfy on 2015/8/5.
 * Count and Say
 */

class Solution {
	public String countAndSay(int n) {
		int i, j, len;
		char ch;
		StringBuilder s1 = new StringBuilder("1");
		StringBuilder s2 = s1;
		for (i = 2; i <= n; i++) {
			ch = s1.charAt(0);
			j = len = 0;
			s2 = new StringBuilder();
			while (j < s1.length()) {
				if (s1.charAt(j) == ch) {
					j++;
					len++;
				} else {
					s2.append(String.valueOf(len)).append(ch);
					ch = s1.charAt(j);
					j++;
					len = 1;
				}
			}
			s2.append(String.valueOf(len)).append(ch);
			s1 = s2;
		}
		return s2.toString();
	}
}

public class P38 {
	public static void main(String[] args) {
		new Solution().countAndSay(9);
	}
}
