// use two pointers, move to middle
public class Solution {
    public int trap(int[] height) {
        int i = 0, j = height.length - 1, sum = 0, h = 0;
        while (i < j) {
            if (height[i] < height[j]) {
                h = Math.max(height[i], h);
                sum += h - height[i];
                i++;
            } else {
                h = Math.max(height[j], h);
                sum += h - height[j];
                j--;
            }
        }
        return sum;
    }
}
