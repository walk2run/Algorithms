import java.util.PriorityQueue;

/**
 * Created by yfy on 2/21/17.
 * 407. Trapping Rain Water II
 */

class Solution {
  private int[][] heightMap;
  private boolean[][] visited;
  private PriorityQueue<Cell> queue;

  public int trapRainWater(int[][] heightMap) {
    this.heightMap = heightMap;
    PriorityQueue<Cell> queue = new PriorityQueue<>();
    this.queue = queue;
    int n = heightMap.length;
    if (n == 0) return 0;
    int m = heightMap[0].length;
    if (m == 0) return 0;
    boolean[][] visited = new boolean[n][m];
    this.visited = visited;
    for (int i = 0; i < n; i++) {
      add(i, 0);
      add(i, m - 1);
    }
    for (int j = 1; j < m - 1; j++) {
      add(0, j);
      add(n - 1, j);
    }
    int level = 0, sum = 0;
    while (!queue.isEmpty()) {
      Cell cell = queue.poll();
      if (cell.h < level)
        sum += level - cell.h;
      else
        level = cell.h;
      int x = cell.x, y = cell.y;
      if (x + 1 < n && !visited[x + 1][y]) add(x + 1, y);
      if (x - 1 >= 0 && !visited[x - 1][y]) add(x - 1, y);
      if (y + 1 < m && !visited[x][y + 1]) add(x, y + 1);
      if (y - 1 >= 0 && !visited[x][y - 1]) add(x, y - 1);
    }
    return sum;
  }

  private void add(int x, int y) {
    queue.add(new Cell(x, y, heightMap[x][y]));
    visited[x][y] = true;
  }

  private static class Cell implements Comparable {
    int x, y, h;

    public Cell(int x, int y, int h) {
      this.x = x;
      this.y = y;
      this.h = h;
    }

    @Override
    public int compareTo(Object o) {
      Cell c = (Cell) o;
      return h - c.h;
    }
  }
}

public class P407 {

}
