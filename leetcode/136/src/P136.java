// 136. Single Number

class Solution {
  public int singleNumber(int[] nums) {
    int x = 0;
    for (int num : nums)
      x ^= num;
    return x;
  }
}

public class P136 {
}
