import java.util.Scanner;

/**
 * Created by yfy on 2017/4/9.
 */
public class P2 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int m = scan.nextInt();
    int k = scan.nextInt();
    int[][] a = new int[n][m];
    //int[][] s = new int[n][m];
    for (int i = 0; i < n; i++)
      for (int j = 0; j < m; j++)
        a[i][j] = scan.nextInt();
    for (int j = 0; j < m; j++) {
      int sum = 0;
      for (int i = 0; i < n; i++) {
        a[i][j] += sum;
        sum = a[i][j];
      }
    }
    for (int i1 = 0; i1 < n; i1++)
      for (int i2 = 0; i2 < n; i2++) {
        int j1 = 0, j2 = 0;

      }
  }
}