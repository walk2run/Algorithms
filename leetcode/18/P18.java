public class Solution {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);
    List<List<Integer>> lists = new ArrayList<>();
    for (int i = 0; i < nums.length - 3; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) continue;
      int a = nums[i];
      for (int j = i + 1; j < nums.length - 2; j++) {
        if (j > i + 1 && nums[j] == nums[j - 1]) continue;
        int b = nums[j];
        int k = j + 1;
        int l = nums.length - 1;
        while (k < l) {
          int c = nums[k];
          int d = nums[l];
          int s = a + b + c + d;
          if (s > target)
            l--;
          else if (s < target)
            k++;
          else {
            lists.add(new ArrayList<>(Arrays.asList(a, b, c, d)));
            while (k < nums.length && nums[k] == c) k++;
          } 
        }
      }
    }
    return lists;
  }
}