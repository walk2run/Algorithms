/**
 * Created by yfy on 2015/8/14.
 * Jump Game
 */

class Solution {
	public boolean canJump(int[] nums) {
		int i, max;
		for (max = i = 0; i <= max; i++) {
			if (i + nums[i] > max) max = i + nums[i];
			if (max >= nums.length - 1) return true;
		}
		return false;
	}
}

public class P55 {
}
