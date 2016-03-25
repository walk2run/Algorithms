import java.util.Scanner;

/**
 * Created by qwordy on 3/24/16.
 * 1270
 */

public class P1270 {
  public static void main(String[] args) {
    int q, i;
    scanner = new Scanner(System.in);
    q = scanner.nextInt();
    for (i = 0; i < q; i++)
      solve();
  }

  static void solve() {
    int n, m, k, t, i, j, cost, min, level, sum;
    n = scanner.nextInt();
    m = scanner.nextInt();
    k = scanner.nextInt();
    t = scanner.nextInt();
    int[] a = new int[m];
    int[] b = new int[m];
    int[] d = new int[k + 1];
    for (i = 0; i < m; i++)
      a[i] = scanner.nextInt();
    for (i = 0; i < m; i++)
      b[i] = scanner.nextInt();
    sum = 0;
    for (level = 0; level < n; level++) {
      for (i = 1; i <= k; i++) {
        min = Integer.MAX_VALUE;
        for (j = 0; j < m; j++) {
          cost = b[j] == 0 ? Integer.MAX_VALUE : (i - b[j] < 0 ? 0 : d[i - b[j]]) + a[j];
          if (cost < min) min = cost;
        }
        d[i] = min;
      }
      if (d[k] == Integer.MAX_VALUE) {
        System.out.println("No Answer");
        return;
      }
      sum += d[k];
      for (i = 0; i < m; i++) b[i] /= t;
    }
    System.out.println(sum);
  }

  static Scanner scanner;
}
