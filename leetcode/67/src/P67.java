import java.math.BigInteger;
import java.util.Arrays;

/**
 * Created by yfy on 9/22/15.
 * Add Binary
 */

class Solution {
	public String addBinary(String a, String b) {
		int i, s;
		char[] c = new char[Math.max(a.length(), b.length()) + 1];
		Arrays.fill(c, '0');
		for (i = 0; i < c.length - 1; i++) {
			s = getNum(a, i) + getNum(b, i) + c[c.length - i - 1] - '0';
			c[c.length - i - 1] = (char)(s % 2 + '0');
			c[c.length - i - 2] = (char)(s / 2 + '0');
		}
		if (c[0] == '1')
			return new String(c, 0, c.length);
		else
			return new String(c, 1, c.length - 1);
	}

	int getNum(String a, int i) {
		if (i < a.length())
			return a.charAt(a.length() - i - 1) - '0';
		else
			return 0;
	}
}

public class P67 {

}
