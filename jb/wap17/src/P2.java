import java.util.Scanner;

public class P2 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int m = scan.nextInt();
    char[][] a = new char[n][m];
    for (int i = 0; i < n; i++) {
      String s = scan.next();
      for (int j = 0; j < m; j++)
        a[i][j] = s.charAt(j);
    }
    int p = scan.nextInt();

    int[][] num = new int[n][m];
    for (int i = 0; i < n; i++) {
      int count = 0;
      for (int j = 0; j < m; j++) {
        if (a[i][j] == 'o')
          count++;
        num[i][j] = count;
      }
    }

    int ans = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        for (int k = j; k < m; k++) {
          int sum = 0;
          for (int l = i; l < n; l++) {
            sum += num[l][k] - (j > 0 ? num[l][j - 1] : 0);
            if (sum == p) {
              int d1 = i, d2 = n - 1 - l;
              int min = Math.min(d1, d2), max = Math.max(d1, d2);
              int step = min * 2 + max;
              d1 = j;
              d2 = m - 1 - k;
              min = Math.min(d1, d2);
              max = Math.max(d1, d2);
              step += min * 2 + max;
              ans = Math.min(ans, step);
            } else if (sum > p) {
              break;
            }
          }
        }
      }
    }

    System.out.println(ans == Integer.MAX_VALUE ? -1 : ans);
  }
}
