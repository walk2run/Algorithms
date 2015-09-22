/**
 * Created by yfy on 9/22/15.
 * Valid Number
 */

class Solution {
	public boolean isNumber(String s) {
		s = s.trim();
		return s.matches("[+-]?((\\d+\\.?\\d*)|(\\.\\d+))(e[+-]?\\d+)?");
	}
}

public class P65 {
	public static void main(String[] args) {
		System.out.println(new Solution().isNumber("2e0"));
	}
}
