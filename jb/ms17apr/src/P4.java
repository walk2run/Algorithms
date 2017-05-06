import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by yfy on 2017/4/14.
 */
public class P4 {
  static int n;
  static int[] fa, in, ip, cost;
  static int[][] children;

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    fa = new int[n + 1];
    in = new int[n + 1];
    ip = new int[n + 1];
    cost = new int[n + 1];
    int root = 1;
    for (int i = 1; i <= n; i++) {
      fa[i] = scan.nextInt();
      in[i] = scan.nextInt();
      ip[i] = scan.nextInt();
      cost[i] = scan.nextInt();
      if (fa[i] == 0) root = i;
    }
    System.out.println(kill(root));
  }

  private static int kill(int node) {
    int info = in[node];
    int[] d = new int[info + 1];  // min cost
    Arrays.fill(d, Integer.MAX_VALUE);
    d[0] = 0;
    for (int i = 1; i <= n; i++) {
      if (fa[i] == node) {
        for (int j = info; j >= ip[i]; j--)
          d[j] = Math.min(d[j], Math.max(0, d[j - ip[i]]) + kill(i) + cost[i]);
      }
    }
    System.out.println(node + " " + d[info]);
    return d[info];
  }
}
