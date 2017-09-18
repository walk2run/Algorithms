// 162. Find Peak Element

class Solution {
  public int findPeakElement(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      int a = i == 0 ? Integer.MIN_VALUE : nums[i - 1];
      int b = nums[i];
      int c = i == nums.length - 1 ? Integer.MIN_VALUE : nums[i + 1];
      if (b > a && b > c) return i;
    }
    return 0;
  }
}

public class P162 {
}
