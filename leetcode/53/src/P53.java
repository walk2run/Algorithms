/**
 * Created by yfy on 2015/8/13.
 * Maximum Subarray
 */

class Solution {
	public int maxSubArray(int[] nums) {
		int[] d = new int[nums.length];
		int max;
		max = d[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (d[i - 1] > 0)
				d[i] = d[i - 1] + nums[i];
			else
				d[i] = nums[i];
			if (d[i] > max) max = d[i];
		}
		return max;
	}
}

public class P53 {
	public static void main(String[] args) {
		System.out.println(new Solution().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
	}
}
