import java.util.Scanner;

// dp
public class P3 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int k = scan.nextInt();
    int[][][] d = new int[2 * n + 1][n + 1][n + 1];
    for (int i = 1; i <= 2 * n; i++) {
      for (int j = 0; j <= Math.min(n, i); j++) {
        for (int b = Math.max(0, j - i + j); b <= j; b++) {
          int add1; // add (
          if (j == 0 || b == 0)
            add1 = 0;
          else {
            if (i == 1)
              add1 = 1;
            else
              add1 = d[i - 1][j - 1][b - 1];
          }
          int add2; // add )
          if (b == n)
            add2 = 0;
          else {
            if (i == 1)
              add2 = b == 0 ? 1 : 0;
            else {
              add2 = d[i - 1][j][b + 1];
              if (b == 0) add2 += d[i - 1][j][b];
            }
          }
          d[i][j][b] = (add1 + add2) % 1000000007;
          //System.out.printf("%d %d %d %d\n", i, j, b, d[i][j][b]);
        }
      }
    }
    System.out.println(d[2 * n][n][k]);
  }
}
