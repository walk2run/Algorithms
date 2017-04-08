public class Solution {
  public int search(int[] nums, int target) {
    int l = 0, r = nums.length - 1;
    if (r == -1) return -1;
    while (l < r) {
      int mid = (l + r) / 2;
      if (nums[l] <= nums[mid]) {
        if (nums[l] <= target && target <= nums[mid])
          r = mid;
        else
          l = mid + 1;
      } else {
        if (nums[mid + 1] <= target && target <= nums[r])
          l = mid + 1;
        else
          r = mid;
      }
    }
    return nums[l] == target ? l : -1;
  }
}