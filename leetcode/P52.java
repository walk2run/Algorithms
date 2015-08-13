public class Solution {
	public int totalNQueens(int n) {
		this.n = n;
		count = 0;
		search(0, 0, 0, 0);
		return count;
	}

	void search(int depth, int left, int right, int vert) {
		int all, i, t;
		if (depth == n) count++;
		all = left | right | vert;
		for (i = 0; i < n; i++) {
			if (all % 2 == 0) {
				stack.push(i);
				t = 1 << i;
				search(depth + 1, (left | t) << 1,  (right | t) >> 1, vert | t);
				stack.pop();
			}
			all /= 2;
		}
	}

	int n, count;
	Stack<Integer> stack = new Stack<>();
}