import java.util.Stack;

/**
 * Created by yfy on 2015/8/4.
 * Divide Two Integers
 */
class Pair {
	int div, qua;

	Pair(int div, int qua) {
		this.div = div;
		this.qua = qua;
	}
}

class Solution {
	public int divide(int dividend, int divisor) {
		int div, qua, d1, d2, res;

		res = 0;
		if (divisor == 0)
			return Integer.MAX_VALUE;
		if (divisor == 1)
			return dividend;
		if (dividend == 0)
			return 0;
		if (dividend == Integer.MIN_VALUE) {
			if (divisor == -1)
				return Integer.MAX_VALUE;
			res = 1;
			dividend += Math.abs(divisor);
		}

		d1 = dividend;
		d2 = divisor;
		dividend = Math.abs(d1);
		divisor = Math.abs(d2);

		div = divisor;
		qua = 1;
		Stack<Pair> ds = new Stack<>();
		while (div > 0 && div <= dividend) {
			ds.add(new Pair(div, qua));
			div += div;
			qua += qua;
		}

		while (!ds.empty()) {
			Pair pair = ds.pop();
			if (dividend >= pair.div) {
				res += pair.qua;
				dividend -= pair.div;
			}
		}

		if (d1 > 0 && d2 < 0 || d1 < 0 && d2 > 0)
			res = -res;

		return res;
	}
}

public class P29 {
	public static void main(String[] args) {
		System.out.println(new Solution().divide(-2147483648, 1));
	}
}
