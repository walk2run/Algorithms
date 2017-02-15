import java.util.*;

/**
 * Created by yfy on 2/15/2017.
 */

class Pair {
  public int a, b, c, d, time;

  public Pair(int a, int b, int c, int d, int time) {
    this.a = a;
    this.b = b;
    this.c = c;
    this.d = d;
    this.time = time;
  }

  @Override
  public int hashCode() {
    return a * 1000 + b * 100 + c * 10 + d;
  }

  @Override
  public boolean equals(Object obj) {
    Pair p = (Pair) obj;
    return p.a == a && p.b == b && p.c == c && p.d == d;
  }
}

public class P3 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int m = scan.nextInt();
    char[][] board = new char[n][m];
    int i, j, a, b, c, d;
    a = b = c = d = 0;
    for (i = 0; i < n; i++) {
      String line = scan.next();
      for (j = 0; j < m; j++) {
        board[i][j] = line.charAt(j);
        if (board[i][j] == 'X') {
          a = i;
          b = j;
          board[i][j] = '.';
        } else if (board[i][j] == '*') {
          c = i;
          d = j;
          board[i][j] = '.';
        }
      }
    }

    Set<Pair> set = new HashSet<>();
    Queue<Pair> queue = new LinkedList<>();
    queue.add(new Pair(a, b, c, d, 0));
    while (!queue.isEmpty()) {
      Pair p = queue.remove();
      if (p.a + 1 < n && (p.a + 1 != p.c || p.b != p.d ) && (board[p.a + 1][p.b] == '.' || board[p.a + 1][p.b] == '@')) {
        Pair np = new Pair(p.a + 1, p.b, p.c, p.d, p.time + 1);
        if (!set.contains(np)) {
          set.add(np);
          queue.add(np);
        }
      }
      if (p.a - 1 >= 0 && (p.a - 1 != p.c || p.b != p.d ) && (board[p.a - 1][p.b] == '.' || board[p.a - 1][p.b] == '@')) {
        Pair np = new Pair(p.a - 1, p.b, p.c, p.d, p.time + 1);
        if (!set.contains(np)) {
          set.add(np);
          queue.add(np);
        }
      }
      if (p.b + 1 < m && (p.a != p.c || p.b + 1 != p.d ) && (board[p.a][p.b + 1] == '.' || board[p.a][p.b + 1] == '@')) {
        Pair np = new Pair(p.a, p.b + 1, p.c, p.d, p.time + 1);
        if (!set.contains(np)) {
          set.add(np);
          queue.add(np);
        }
      }
      if (p.b - 1 >= 0 && (p.a != p.c || p.b - 1 != p.d ) && (board[p.a][p.b - 1] == '.' || board[p.a][p.b - 1] == '@')) {
        Pair np = new Pair(p.a, p.b - 1, p.c, p.d, p.time + 1);
        if (!set.contains(np)) {
          set.add(np);
          queue.add(np);
        }
      }
      if (p.a + 2 < n && p.a + 1 == p.c && p.b == p.d && (board[p.a + 2][p.b] == '.' || board[p.a + 2][p.b] == '@')) {
        Pair np = new Pair(p.a + 1, p.b, p.c + 1, p.d, p.time + 1);
        if (board[np.c][np.d] == '@') {
          System.out.println(np.time);
          return;
        }
        if (!set.contains(np)) {
          set.add(np);
          queue.add(np);
        }
      }
      if (p.a - 2 >= 0 && p.a - 1 == p.c && p.b == p.d && (board[p.a - 2][p.b] == '.' || board[p.a - 2][p.b] == '@')) {
        Pair np = new Pair(p.a - 1, p.b, p.c - 1, p.d, p.time + 1);
        if (board[np.c][np.d] == '@') {
          System.out.println(np.time);
          return;
        }
        if (!set.contains(np)) {
          set.add(np);
          queue.add(np);
        }
      }
      if (p.b + 2 < m && p.a == p.c && p.b + 1 == p.d && (board[p.a][p.b + 2] == '.' || board[p.a][p.b + 2] == '@')) {
        Pair np = new Pair(p.a, p.b + 1, p.c, p.d + 1, p.time + 1);
        if (board[np.c][np.d] == '@') {
          System.out.println(np.time);
          return;
        }
        if (!set.contains(np)) {
          set.add(np);
          queue.add(np);
        }
      }
      if (p.b - 2 >= 0 && p.a == p.c && p.b - 1 == p.d && (board[p.a][p.b - 2] == '.' || board[p.a][p.b - 2] == '@')) {
        Pair np = new Pair(p.a, p.b - 1, p.c, p.d - 1, p.time + 1);
        if (board[np.c][np.d] == '@') {
          System.out.println(np.time);
          return;
        }
        if (!set.contains(np)) {
          set.add(np);
          queue.add(np);
        }
      }
    }
    System.out.println(-1);
  }
}
