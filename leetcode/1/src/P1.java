import java.util.HashMap;
import java.util.Map;

/**
 * Created by yfy on 11/1/16.
 * Two Sum
 */

class Solution {
  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      Integer idx = map.get(nums[i]);
      if (idx == null)
        map.put(nums[i], i);
      else
        if (nums[i] * 2 == target) return new int[]{idx, i};
    }
    for (int num : nums) {
      Integer idx2 = map.get(target - num);
      if (idx2 != null) {
        int idx1 = map.get(num);
        if (idx1 == idx2) continue;
        return new int[]{Math.min(idx1, idx2), Math.max(idx1, idx2)};
      }
    }
    return null;
  }
}

public class P1 {
  public static void main(String[] args) {
    new Solution().twoSum(new int[]{3, 2, 4}, 6);
  }
}
