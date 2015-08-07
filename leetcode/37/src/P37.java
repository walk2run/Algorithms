import java.util.Arrays;

/**
 * Created by yfy on 2015/8/7.
 * Sudoku Solver
 */

class Solution {
	public void solveSudoku(char[][] board) {
		search(board, 0);
	}

	boolean search(char[][] board, int depth) {
		if (depth == 81) return true;

		int x, y, i;
		x = depth / 9;
		y = depth % 9;
		if (board[x][y] != '.') {
			if (search(board, depth + 1))
				return true;
		} else {
			for (i = 1; i <= 9; i++) {
				board[x][y] = (char)('0' + i);
				if (valid(board))
					if (search(board, depth + 1))
						return true;
			}
			board[x][y] = '.';
		}

		return false;
	}

	boolean valid(char[][] board) {
		int i, j, k, num;
		char ch;
		boolean[][] app = new boolean[3][10];

		for (i = 0; i < 9; i++) {
			Arrays.fill(app[0], false);
			Arrays.fill(app[1], false);
			Arrays.fill(app[2], false);
			for (j = 0; j < 9; j++) {
				for (k = 0; k < 3; k++) {
					if (k == 0)
						ch = board[i][j];
					else if (k == 1)
						ch = board[j][i];
					else
						ch = getChar(i, j, board);
					if (ch != '.') {
						num = ch - '0';
						if (app[k][num])
							return false;
						else
							app[k][num] = true;
					}
				}
			}
		}

		return true;
	}

	char getChar(int i, int j, char[][] board) {
		int x, y;
		x = i / 3 * 3 + j / 3;
		y = i % 3 * 3 + j % 3;
		return board[x][y];
	}
}

public class P37 {
}
