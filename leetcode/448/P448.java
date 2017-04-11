public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int j = Math.abs(nums[i]) - 1;
            if (nums[j] > 0) nums[j] *= -1;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) list.add(i + 1);
        }
        return list;
    }
}