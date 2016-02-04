/**
 * Created by yfy on 2/4/16.
 * 88. Merge Sorted Array
 */

class Solution {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int i, j, k;
		int[] nums3 = new int[m + n];
		i = j = k = 0;
		while (i < m && j < n) {
			if (nums1[i] < nums2[j]) {
				nums3[k++] = nums1[i];
				i++;
			} else {
				nums3[k++] = nums2[j];
				j++;
			}
		}
		System.arraycopy(nums1, i, nums3, k, m - i);
		System.arraycopy(nums2, j, nums3, k + m - i, n - j);
		System.arraycopy(nums3, 0, nums1, 0, m + n);
	}
}

public class P88 {

}
