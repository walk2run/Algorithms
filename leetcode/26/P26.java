public class Solution {
  public int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;
    int last = nums[0], count = 0;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != last) {
        nums[count++] = last;
        last = nums[i];
      }
    }
    nums[count++] = nums[nums.length - 1];
    return count;
  }
}