public class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> lists = new ArrayList<>();
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
        if (s > 0)
          k--;
        else if (s < 0)
          j++;
        else {
          lists.add(new ArrayList<>(Arrays.asList(a, b, c)));
          while (j < nums.length && nums[j] == b) j++;
        }
      }
    }
    return lists;
  }
}

public class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    
  }
}