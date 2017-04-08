public class Solution {
  public int[] searchRange(int[] nums, int target) {
    int l = 0, r = nums.length - 1;
    if (r == -1) return new int[]{-1, -1};
    while (l < r) {
      int mid = (l + r) / 2;
      if (target <= nums[mid])
        r = mid;
      else
        l = mid + 1;
    }
    if (nums[l] != target)
      return new int[]{-1, -1};
    int ans1 = l;
    l = 0;
    r = nums.length - 1;
    while (l < r) {
      int mid = (l + r + 1) / 2;
      if (target < nums[mid])
        r = mid - 1;
      else
        l = mid;
    }
    return new int[]{ans1, l};
  }
}