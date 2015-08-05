import java.util.Arrays;

/**
 * Created by yfy on 2015/8/5.
 * Valid Sudoku
 */
class Solution {
	public boolean isValidSudoku(char[][] board) {
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

public class P36 {
}
