// 162. Find Peak Element

class Solution {
  public int findPeakElement(int[] nums) {
    int n = nums.length;
    for (int i = 0; i < nums.length; i++) {
      if (i == 0) {
        if (n > 1 && nums[0] > nums[1]) return 0;
      } else if (i == n - 1) {
        if (n > 1 && nums[i] > nums[i - 1]) return i;
      } else {
        if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) return i;
      }
    }
    return 0;
  }
}

class Solution {
  public int findPeakElement(int[] nums) {
    int l = 0, r = nums.length - 1;
    while () {

    }
  }
}

public class P162 {
}
