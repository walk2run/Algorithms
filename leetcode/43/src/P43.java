import java.math.BigInteger;

/**
 * Created by yfy on 2015/8/8.
 * Multiply Strings
 */

class Solution {
	public String multiply(String num1, String num2) {
		BigInteger a = new BigInteger(num1);
		BigInteger b = new BigInteger(num2);
		return a.multiply(b).toString();
	}
}

public class P43 {
	public static void main(String[] args) {
		System.out.println(new Solution().multiply("123", "456"));
	}
}
