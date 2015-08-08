/**
 * Created by yfy on 2015/8/8.
 * First Missing Positive
 */

class Solution {
	public int firstMissingPositive(int[] nums) {
		int i, j ,t;
		for (i = 0; i < nums.length; i++) {
			while (nums[i] > 0 && nums[i] != i + 1) {
				j = nums[i] - 1;
				if (j >= nums.length || nums[i] == nums[j]) {
					nums[i] = -1;
				} else {
					t = nums[i];
					nums[i] = nums[j];
					nums[j] = t;
				}
			}
		}
		for (i = 0; i < nums.length && nums[i] == i + 1; i++);
		return i + 1;
	}
}

public class P41 {
	public static void main(String[] args) {
		System.out.println(new Solution().firstMissingPositive(new int[]{1, 1, 3}));
	}
}
