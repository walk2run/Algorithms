// 153. Find Minimum in Rotated Sorted Array

class Solution {
  public int findMin(int[] nums) {
    int l = 0, r = nums.length - 1;
    while (l < r) {
      if (nums[l] < nums[r])
        return nums[l];
      int mid = (l + r) / 2;
      if (nums[mid] > nums[r])
        l = mid + 1;
      else if (nums[mid] < nums[l])
        r = mid;
      else
        r--;
    }
    return nums[l];
  }
}

public class P153 {
}
