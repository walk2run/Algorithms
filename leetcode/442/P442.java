public class Solution {
  public List<Integer> findDuplicates(int[] nums) {
    int n = nums.length;
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      while (nums[i] != -1 && nums[i] != i + 1) {
        int j = nums[i] - 1;
        if (nums[j] != nums[i]) {
          int t = nums[i];
          nums[i] = nums[j];
          nums[j] = t;
        } else {
          list.add(nums[j]);
          nums[i] = -1;
        }
      }
    }
    return list;
  }
}

public class Solution {
  public List<Integer> findDuplicates(int[] nums) {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
      int v = Math.abs(nums[i]);
      if (nums[v - 1] < 0)
        list.add(v);
      else
        nums[v - 1] = -nums[v - 1];
    }
    return list;
  }
}
