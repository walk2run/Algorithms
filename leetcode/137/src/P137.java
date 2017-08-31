// 137. Single Number II

class Solution {
  public int singleNumber(int[] nums) {
    int ans = 0;
    for (int i = 0; i < 32; i++) {
      int sum = 0;
      for (int num : nums)
        sum += num >>> i & 1;
      ans += sum % 3 << i;
    }
    return ans;
  }
}

public class P137 {
}
