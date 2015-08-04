/**
 * Created by yfy on 2015/8/4.
 * Search in Rotated Sorted Array
 */
public class Solution {
	public int search(int[] nums, int target) {
		int l, r, mid, v0, v1, v2;

		l = 0;
		r = nums.length - 1;
		while (l < r) {
			mid = (l + r) / 2;
			v0 = nums[l];
			v1 = nums[mid];
			v2 = nums[r];
			if (v0 <= v1 && v1 <= v2) {
				if (target >= v0 && target <= v1)
					r = mid;
				else if (target > v1 && target <= v2)
					l = mid + 1;
				else
					return -1;
			} else if (v0 <= v1 && v1 >= v2) {
				if (target >= v0 && target <= v1)
					r = mid;
				else
					l = mid + 1;
			} else {
				if (target >= v1 && target <= v2)
					l = mid;
				else
					r = mid - 1;
			}
		}

		if (nums[l] == target)
			return l;
		else
			return -1;
	}
}
