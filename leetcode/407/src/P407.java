import java.util.PriorityQueue;

/**
 * Created by yfy on 2/21/17.
 * 407. Trapping Rain Water II
 */

class Cell implements Comparable {
  int x, y;

  public Cell(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int h() {
    return Solution.hs[x][y];
  }

  @Override
  public int compareTo(Object o) {
    Cell c = (Cell) o;
    return Solution.hs[x][y] - Solution.hs[c.x][c.y];
  }
}

class Solution {
  public static int[][] hs;

  public int trapRainWater(int[][] heightMap) {
    hs = heightMap;
    PriorityQueue<Cell> queue = new PriorityQueue<>();
    int n = heightMap.length, m = heightMap.length;
    for (int i = 0; i < n; i++) {
      queue.add(new Cell(i, 0));
      queue.add(new Cell(i, m - 1));
    }
    for (int j = 1; j < m; j++) {
      queue.add(new Cell(0, j));
      queue.add(new Cell(n - 1, j));
    }
    int level = 0, sum = 0;
    while () {
      Cell cell = queue.poll();
      if (cell.h() < level) {
        sum += level - cell.h();
      }
    }
  }
}

public class P407 {

}
