import java.util.Arrays;

/**
 * Created by yfy on 2015/8/3.
 * Next Permutation
 */
class Solution {
	public void nextPermutation(int[] nums) {
		int i, j, len, t;
		len = nums.length;
		if (len <= 1) return;
		i = len - 1;

		while (nums[i - 1] >= nums[i])
			if (--i == 0) break;

		if (i > 0) {
			j = len - 1;
			while (nums[j] <= nums[i - 1]) j--;
			t = nums[j];
			nums[j] = nums[i - 1];
			nums[i - 1] = t;
		}

		Arrays.sort(nums, i, len);
	}
}

public class p31 {
	public static void main(String[] args) {
		int[] a = {2, 3, 1};
		new Solution().nextPermutation(a);
		System.out.println(Arrays.toString(a));
	}
}

