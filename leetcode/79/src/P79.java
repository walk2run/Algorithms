/**
 * Created by yfy on 11/10/15.
 * Word Search
 */

class Solution {
	public boolean exist(char[][] board, String word) {
		this.board = board;
		this.word = word;
		n = board.length;
		m = board[0].length;
		use = new boolean[n][m];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if (board[i][j] == word.charAt(0)) {
					use[i][j] = true;
					if (search(i, j, 1)) return true;
					use[i][j] = false;
				}
		return false;
	}

	boolean search(int x, int y, int w) {
		if (w == word.length()) return true;
		int x2, y2;
		for (int i = 0; i < 4; i++) {
			x2 = x + d[i][0];
			y2 = y + d[i][1];
			if (x2 >= 0 && x2 < n &&
				y2 >= 0 && y2 < m &&
				!use[x2][y2] &&
				board[x2][y2] == word.charAt(w)) {
				use[x2][y2] = true;
				if (search(x2, y2, w + 1)) return true;
				use[x2][y2] = false;
			}
		}
		return false;
	}

	char[][] board;
	boolean[][] use;
	String word;
	int n, m;
	int[][] d = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
}

public class P79 {
	public static void main(String[] args) {
		System.out.println(new Solution().exist(new char[][]{{'a', 'a'}}, "aaa"));
	}
}
