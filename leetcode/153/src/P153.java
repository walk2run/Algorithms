// 153. Find Minimum in Rotated Sorted Array

class Solution {
  public int findMin(int[] nums) {
    int n = nums.length;
    int l = 0, r = n - 1;
    if (nums[l] <= nums[r]) return nums[l];
    while () {
      int mid = (l + r) / 2;
      if (mid > nums[l])
    }
  }
}

public class P153 {
}
