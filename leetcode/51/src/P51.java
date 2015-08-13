import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created by yfy on 2015/8/12.
 * N-Queens
 */

class Solution {
	public List<List<String>> solveNQueens(int n) {
		this.n = n;
		dots = new char[n];
		Arrays.fill(dots, '.');
		search(0, 0, 0, 0);
		return lists;
	}

	void search(int depth, int left, int right, int vert) {
		int all, i, t;
		if (depth == n) {
			List<String> list = new ArrayList<>();
			for (int p : stack) {
				StringBuilder st = new StringBuilder();
				st.append(dots);
				st.replace(p, p + 1, "Q");
				list.add(st.toString());
			}
			lists.add(list);
		}
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

	int n;
	Stack<Integer> stack = new Stack<>();
	List<List<String>> lists = new ArrayList<>();
	char[] dots;
}

public class P51 {
	public static void main(String[] args) {
		System.out.println(new Solution().solveNQueens(4));
	}
}
