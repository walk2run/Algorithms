public class Solution {
  public int findDuplicate(int[] nums) {
    int n = nums.length;
    int l = 1, r = n;
    while (l < r) {
      int mid = (l + r) / 2;
      int count = 0;
      for (int num : nums)
        if (num >= l && num <= mid) count++;
      if (count > mid - l + 1)
        r = mid;
      else
        l = mid + 1;
    }
    return l;
  }
}

public class Solution {
  public int findDuplicate(int[] nums) {
    int slow, fast;
    slow = fast = 0;
    while (true) {
      slow = nums[slow];
      fast = nums[nums[fast]];
      if (slow == fast) {
        slow = 0;
        while (slow != fast) {
          slow = nums[slow];
          fast = nums[fast];
        }
        return slow;
      }
    }
  }
}