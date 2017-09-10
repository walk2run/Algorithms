import java.util.Scanner;

public class P4 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    //a = new int[n][n];
    c = new int[n][n][201];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        //a[i][j] = scan.nextInt();
        int v = scan.nextInt();
        for (int k = 1; k <= 200; k++) {
          if (j == 0) c[i][j][k] = 0;
          else c[i][j][k] = c[i][j - 1][k];
          if (k % v == 0) c[i][j][k]++;
        }
      }
    }
    int q = scan.nextInt();
    for (int i = 0; i < q; i++) {
      int x = scan.nextInt() - 1;
      int y = scan.nextInt() - 1;
      int k = scan.nextInt();
      System.out.println(count(x, y, k));
    }
  }

  static int n;
  static int[][][] c;
  static int[][] a;

  static int count(int x, int y, int k) {
    int count = 0;
    for (int i = Math.max(0, x - k); i <= Math.min(n - 1, x + k); i++) {
      int j0 = Math.max(0, y - k + Math.abs(x - i));
      int j1 = Math.min(n - 1, y + k - Math.abs(x - i));
      if (j0 == 0)
        count += c[i][j1][k];
      else
        count += c[i][j1][k] - c[i][j0 - 1][k];
    }
    return count;
  }

  static int count2(int x, int y, int k) {
    int count = 0;
    for (int i = Math.max(0, x - k); i <= Math.min(n - 1, x + k); i++) {
      for (int j = Math.max(0, y - k + Math.abs(x - i)); j <= Math.min(n - 1, y + k - Math.abs(x - i)); j++) {
        if (k % a[i][j] == 0) count++;
      }
    }
    return count;
  }
}
