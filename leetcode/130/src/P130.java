import java.util.*;

/**
 * Created by yfy on 8/12/17.
 * 130. Surrounded Regions
 */

class Solution {
  public void solve(char[][] board) {
    if (board.length == 0) return;
    this.board = board;
    n = board.length;
    m = board[0].length;
    visit = new int[n][m];
    list.add(false);
    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++)
        bfs(i, j);
    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++)
        if (list.get(visit[i][j])) board[i][j] = 'X';
  }

  char[][] board;
  int[][] visit;
  List<Boolean> list = new ArrayList<>();
  int n, m, count;

  void bfs(int i, int j) {
    if (board[i][j] == 'X' || visit[i][j] > 0) return;
    count++;
    boolean sur = true;
    Queue<Integer> queue = new LinkedList<>();
    queue.offer((i << 16) + j);
    while (!queue.isEmpty()) {
      int pos = queue.poll();
      int x = pos >> 16;
      int y = pos & 0xffff;
      if (board[x][y] == 'O' && visit[x][y] == 0) {
        visit[x][y] = count;
        if (x == 0 || x == n - 1 || y == 0 || y == m - 1)
          sur = false;
        if (x + 1 < n) queue.offer((x + 1 << 16) + y);
        if (x - 1 >= 0) queue.offer((x - 1 << 16) + y);
        if (y + 1 < m) queue.offer((x << 16) + y + 1);
        if (y - 1 >= 0) queue.offer((x << 16) + y - 1);
      }
    }
    list.add(sur);
  }
}

  /*boolean dfs(int i, int j) {
    if (board[i][j] == 'X') return true;
    if (visit[i][j]) return true;
    visit[i][j] = true;
    if (i == 0 || i == n - 1 || j == 0 || j == m - 1)
      return false;
    boolean sur = dfs(i + 1, j) && dfs(i - 1, j) && dfs(i, j + 1) && dfs(i, j - 1);
    if (sur) board[i][j] = 'O';
    return sur;
  }*/

class Solution {
  public void solve(char[][] board) {
    if (board.length == 0) return;
    this.board = board;
    n = board.length;
    m = board[0].length;
    for (int i = 0; i < n; i++) {
      bfs(i, 0);
      bfs(i, m - 1);
    }
    for (int j = 1; j < m - 1; j++) {
      bfs(0, j);
      bfs(n - 1, j);
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (board[i][j] == 'O') board[i][j] = 'X';
        if (board[i][j] == 'Y') board[i][j] = 'O';
      }
    }
  }

  char[][] board;
  int n, m;

  void bfs(int i, int j) {
    if (board[i][j] != 'O') return;
    Queue<Integer> queue = new LinkedList<>();
    queue.offer(f(i, j));
    while (!queue.isEmpty()) {
      int pos = queue.poll();
      i = pos >> 16;
      j = pos & 0xffff;
      if (i >= 0 && i < n && j >= 0 && j < m && board[i][j] == 'O') {
        board[i][j] = 'Y';
        queue.offer(f(i + 1, j));
        queue.offer(f(i - 1, j));
        queue.offer(f(i, j + 1));
        queue.offer(f(i, j - 1));
      }
    }
  }

  int f(int i, int j) {
    return (i << 16) + j;
  }

  void dfs(int i, int j) {
    if (i >= n || i < 0 || j >= m || j < 0) return;
    if (board[i][j] != 'O') return;
    board[i][j] = 'Y';
    dfs(i + 1, j);
    dfs(i - 1, j);
    dfs(i, j + 1);
    dfs(i, j - 1);
  }
}

public class P130 {
}