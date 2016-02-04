import java.util.Stack;

/**
 * Created by yfy on 2/4/16.
 * 85. Maximal Rectangle
 */

class Solution {
	public int maximalRectangle(char[][] matrix) {
		int n, m, j, maxArea, area;
		n = matrix.length;
		if (n == 0) return 0;
		m = matrix[0].length;
		int[] heights = new int[m+1];
		maxArea = 0;
		for (char[] line : matrix) {
			for (j = 0; j < m; j++) {
				if (line[j] == '0')
					heights[j] = 0;
				else
					heights[j]++;
			}
			area = maxArea(heights);
			if (area > maxArea) maxArea = area;
		}
		return maxArea;
	}

	// Better
	int maxArea(int[] heights) {
		int maxArea, area, i, p;
		Stack<Integer> stack = new Stack<>();
		maxArea = i = 0;
		while (i < heights.length) {
			if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
				stack.push(i++);
			} else {
				p = stack.pop();
				area = heights[p] * (stack.isEmpty() ? i : i - stack.peek() - 1);
				if (area > maxArea) maxArea = area;
			}
		}
		return maxArea;
	}

	int maxArea0(int[] heights) {
		int maxArea, count, area, j;
		Stack<Integer> stack = new Stack<>();
		maxArea = 0;
		for (int height : heights) {
			if (stack.isEmpty() || height >= stack.peek()) {
				stack.push(height);
			} else {
				count = 0;
				while (!stack.isEmpty() && stack.peek() > height) {
					area = stack.pop() * ++count;
					if (area > maxArea) maxArea = area;
				}
				for (j = 0; j <= count; j++)
					stack.push(height);
			}
		}
		return maxArea;
	}
}

public class P85 {
	public static void main(String[] args) {
		System.out.println(new Solution().maximalRectangle(new char[][]{
				new char[]{'1', '1', '1', '0'},
				new char[]{'0', '1', '1', '0'}}));
	}
}
