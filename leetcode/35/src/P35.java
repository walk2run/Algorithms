/**
 * Created by yfy on 2015/8/5.
 * Search Insert Position
 */
class Solution {
	public int searchInsert(int[] nums, int target) {
		int l, r, mid;

		l = 0;
		r = nums.length - 1;
		while (l < r) {
			mid = (l + r) / 2;
			if (target <= nums[mid])
				r = mid;
			else
				l = mid + 1;
		}

		return target > nums[l] ? l + 1 : l;
	}
}

public class P35 {

}
