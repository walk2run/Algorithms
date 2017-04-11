// xor
public class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int s = 0;
        for (int i = 0; i < n; i++) {
            s ^= nums[i];
            s ^= i + 1;
        }
        return s;
    }
}