import java.util.Scanner;

/**
 * Created by yfy on 2/15/2017.
 */
public class P2 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int d = scan.nextInt();
    int[][] a = new int[n][n];
    int i, j;
    for (i = 0; i < n; i++)
      for (j = 0; j < n; j++)
        a[i][j] = scan.nextInt();
    int max = 0;
    for (i = 0; i < n; i++) {
      int sum = 0;
      for (j = 0; j < d; j++)
        sum += a[i][j];
      max = Math.max(sum, max);
      for (j = d; j < n; j++) {
        sum = sum + a[i][j] - a[i][j - d];
        max = Math.max(sum, max);
      }
    }
    for (j = 0; j < n; j++) {
      int sum = 0;
      for (i = 0; i < d; i++)
        sum += a[i][j];
      max = Math.max(sum, max);
      for (i = d; i < n; i++) {
        sum = sum + a[i][j] - a[i - d][j];
        max = Math.max(sum, max);
      }
    }
//    int sum = 0;
//    for (i = 0; i < d; i++)
//      sum += a[i][i];
//    max = Math.max(sum, max);
//    for (i = d; i < n; i++) {
//      sum = sum + a[i][i] - a[i - d][i - d];
//      max = Math.max(sum, max);
//    }
//    sum = 0;
//    for (i = 0; i < d; i++)
//      sum += a[i][n - 1 - i];
//    max = Math.max(sum, max);
//    for (i = d; i < n; i++) {
//      sum = sum + a[i][n - 1 - i] - a[i - d][n - 1 - (i - d)];
//      max = Math.max(sum, max);
//    }

    for (i = 0; i < n; i++) {
      for (j = 0; j < n; j++) {
        int sum = 0;
        for (int k = 0; k < d; k++) {
          if (i + k < n && j + k < n) {
            sum += a[i + k][j + k];
          } else {
            sum = 0;
            break;
          }
        }
        max = Math.max(sum, max);

        sum = 0;
        for (int k = 0; k < d; k++) {
          if (i + k < n && j - k >= 0) {
            sum += a[i + k][j - k];
          } else {
            sum = 0;
            break;
          }
        }
        max = Math.max(sum, max);
      }
    }
    System.out.println(max);
  }
}
