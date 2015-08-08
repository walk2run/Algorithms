/**
 * Created by yfy on 2015/8/8.
 * Trapping Rain Water
 */

class Solution {
	public int trap(int[] height) {
		int i, j, k, sum;

		i = sum = 0;
		while (true) {
			j = i + 1;
			while (j < height.length && height[j] < height[i])
				j++;
			if (j < height.length) {
				for (k = i + 1; k < j; k++) {
					sum += height[i] - height[k];
					height[k] = height[i];
				}
				i = j;
			} else break;
		}

		i = height.length - 1;
		while (true) {
			j = i - 1;
			while (j >= 0 && height[j] < height[i])
				j--;
			if (j >= 0) {
				for (k = i - 1; k > j; k--)
					sum += height[i] - height[k];
				i = j;
			} else break;
		}

		return sum;
	}
}

public class P42 {
	public static void main(String[] args) {
		System.out.println(new Solution().trap(new int[]{2,0,2}));
	}
}
