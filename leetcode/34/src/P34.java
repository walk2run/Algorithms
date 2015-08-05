import java.util.Arrays;

/**
 * Created by yfy on 2015/8/4.
 * Search for a Range
 */
class Solution {
	public int[] searchRange(int[] nums, int target) {
		int l, r, mid;
		int[] res = new int[2];

		l = 0;
		r = nums.length - 1;
		while (l < r) {
			mid = (l + r) / 2;
			if (target <= nums[mid])
				r = mid;
			else
				l = mid + 1;
		}
		if (nums[l] == target)
			res[0] = l;
		else
			return new int[]{-1, -1};

		l = 0;
		r = nums.length - 1;
		while (l < r) {
			mid = (l + r + 1) / 2;
			if (target < nums[mid])
				r = mid - 1;
			else
				l = mid;
		}
		res[1] = r;

		return res;
	}
}

public class P34 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new Solution().searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
	}
}
