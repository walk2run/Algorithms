import java.util.*;



public class P2 {
  static int minMoves(int[][] maze, int x, int y) {
    n = maze.length;
    xx = x;
    yy = y;

    map = new HashMap<>();
    int count = 0;
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        if (maze[i][j] == 2) map.put(i * n + j, count++);
    full = (1 << count) - 1;

    queue = new LinkedList<>();
    queue.add(new Pair(0, 0, maze[0][0] == 2 ? 1 : 0, 0));
    d = new boolean[n][n][1024];
    d[0][0][maze[0][0] == 2 ? 1 : 0] = true;
    while (!queue.isEmpty()) {
      Pair p = queue.poll();
      if (p.x > 0 && maze[p.x - 1][p.y] != 1) {
        int c = f(maze, p, -1, 0);
        if (c >= 0) return c;
      }
      if (p.x < n - 1 && maze[p.x + 1][p.y] != 1) {
        int c = f(maze, p, 1, 0);
        if (c >= 0) return c;
      }
      if (p.y > 0 && maze[p.x][p.y - 1] != 1) {
        int c = f(maze, p, 0, -1);
        if (c >= 0) return c;
      }
      if (p.y < n - 1 && maze[p.x][p.y + 1] != 1) {
        int c = f(maze, p, 0, 1);
        if (c >= 0) return c;
      }
    }
    return -1;
  }

  static int n, xx, yy, full;
  static boolean[][][] d;
  static Map<Integer, Integer> map;
  static Queue<Pair> queue;

  static int f(int[][] maze, Pair p, int x, int y) {
    x += p.x;
    y += p.y;
    int s = p.s;
    if (maze[x][y] == 2)
      s |= 1 << map.get(x * n + y);
    if (d[x][y][s]) return -1;
    if (x == xx && y == yy && s == full) return p.c + 1;
    Pair np = new Pair(x, y, s, p.c + 1);
    queue.offer(np);
    d[x][y][s] = true;
    return -1;
  }

  static class Pair {
    int x, y, s, c;

    public Pair(int x, int y, int s, int c) {
      this.x = x;
      this.y = y;
      this.s = s;
      this.c = c;
    }
  }

  public static void main(String[] args) {
    System.out.println(minMoves(new int[][]{{0, 1, 0}, {1, 0, 1}, {0, 2, 2}}, 1, 1));
  }
}
