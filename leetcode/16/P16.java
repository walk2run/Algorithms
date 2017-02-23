public class Solution {
  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int min = Integer.MAX_VALUE, ans = 0;
    for (int i = 0; i < nums.length - 2; i++) {
      if (i > 0 && nums[i] == nums[i - 1])
        continue;
      int a = nums[i];
      int j = i + 1;
      int k = nums.length - 1;
      while (j < k) {
        int b = nums[j];
        int c = nums[k];
        int s = a + b + c;
        if (Math.abs(s - target) < min) {
          min = Math.abs(s - target);
          ans = s;
        }
        if (s == target)
          return s;
        else if (s > target)
          k--;
        else if (s < target)
          j++;
      }
    }
    return ans;
  }
}