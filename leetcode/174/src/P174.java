// 174. Dungeon Game

class Solution {
  public int calculateMinimumHP(int[][] dungeon) {
    int n = dungeon.length;
    int m = dungeon[0].length;
    int[][] d = new int[n][m];
    for (int i = n - 1; i >= 0; i--) {
      for (int j = m - 1; j >= 0; j--) {
        int min = Integer.MAX_VALUE;
        if (i + 1 < n && d[i + 1][j] < min) min = d[i + 1][j];
        if (j + 1 < m && d[i][j + 1] < min) min = d[i][j + 1];
        if (i + 1 == n && j + 1 == m) min = 1;
        min -= dungeon[i][j];
        if (min < 1) min = 1;
        d[i][j] = min;
      }
    }
    return d[0][0];
  }
}

public class P174 {
}
