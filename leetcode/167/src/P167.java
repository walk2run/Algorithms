// 167. Two Sum II - Input array is sorted

class Solution {
  public int[] twoSum(int[] numbers, int target) {
    int i = 0, j = numbers.length - 1;
    while (i < j) {
      if (numbers[i] + numbers[j] < target)
        i++;
      else if (numbers[i] + numbers[j] > target)
        j--;
      else
        return new int[]{i + 1, j + 1};
    }
    return null;
  }
}

public class P167 {
}
