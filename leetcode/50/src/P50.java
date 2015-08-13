/**
 * Created by yfy on 2015/8/12.
 * Pow(x, n)
 */

class Solution {
	public double myPow(double x, int n) {
		double a, y;
		boolean pos = n > 0;
		n = Math.abs(n);
		a = x;
		y = 1;
		while (n > 0) {
			if (n % 2 == 1) y *= a;
			a *= a;
			n >>= 1;
		}
		return pos ? y : 1 / y;
	}
}

public class P50 {
	public static void main(String[] args) {
		System.out.println(new Solution().myPow(2, 10));
	}
}
