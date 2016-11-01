import java.util.Arrays;

class Solution {
	public int[] plusOne(int[] digits) {
		int[] sum = new int[digits.length + 1];
		digits[digits.length-1]++;
		for (int i = digits.length - 1; i >= 0; i--) {
			sum[i+1] += digits[i];
			if (sum[i+1] == 10) {
				sum[i+1] = 0;
				sum[i]++;
			}
		}
		if (sum[0] == 0)
			sum = Arrays.copyOfRange(sum, 1, sum.length);
		return sum;
	}
}

class P66 {
	public static void main(String[] args) {
		int[] sum = new Solution().plusOne(new int[] {9, 9, 9});
		for (int x : sum)
			System.out.print(x + " ");
	}
}