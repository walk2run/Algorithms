// 169. Majority Element

class Solution {
  public int majorityElement(int[] nums) {
    int count = 0, a = 0;
    for (int num : nums) {
      if (count == 0) {
        a = num;
        count++;
      } else if (num == a)
        count++;
      else
        count--;
    }
    return a;
  }
}

public class P169 {
}
