/**
 * Created by yfy on 10/31/15.
 * Sort Colors
 */

class Solution {
	public void sortColors(int[] nums) {
		int i, begin, end, t;
		begin = -1;
		end = nums.length;
		i = 0;
		while (i < nums.length && i < end) {
			if (i <= begin) i++;
			else if (nums[i] == 0) {
				begin++;
				t = nums[i];
				nums[i] = nums[begin];
				nums[begin] = t;
			} else if (nums[i] == 2) {
				end--;
				t = nums[i];
				nums[i] = nums[end];
				nums[end] = t;
			} else i++;
		}
	}
}

public class P75 {
}
