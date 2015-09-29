/**
 * Created by yfy on 9/29/15.
 * Sqrt(x)
 */

class Solution {
	public int mySqrt(int x) {
		int l, r, mid;
		l = 0;
		r = 46340;
		while (l < r) {
			mid = (l + r + 1) / 2;
			if (mid * mid <= x)
				l = mid;
			else
				r = mid - 1;
		}
		return l;
	}
}

public class P69 {
}
