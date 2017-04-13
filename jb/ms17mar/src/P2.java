import java.util.Scanner;

/**
 * Created by yfy on 2017/4/13.
 */
public class P2 {
  public static void main(String[] args) {
    int n, m, k, i, j, l1, l2, j2, i3;
    Scanner scan = new Scanner(System.in);
    n = scan.nextInt();
    m = scan.nextInt();  // depth
    k = scan.nextInt();
    int[] a = new int[m];
    int[][] layer = new int[m][n];  // leaves in each layer
    int[] leaves = new int[100];
    int[] fa = new int[n + 1];
    boolean[] isLeaf = new boolean[101];
    int[][] dis = new int[n + 1][n + 1];
    for (i = 0; i < m; i++)
      a[i] = scan.nextInt();
    for (i = 0; i < m; i++)
      for (j = 0; j < a[i]; j++)
        layer[i][j] = scan.nextInt();
    for (i = 0; i < k; i++) {
      leaves[i] = scan.nextInt();
      isLeaf[leaves[i]] = true;
    }
    for (i = 0; i < k; i++)
      for (j = 0; j < k; j++)
        dis[leaves[i]][leaves[j]] = scan.nextInt();

    for (i = m - 1; i > 0; i--) {
      j2 = 0;
      for (j = 0; j < a[i]; j++) {
        l2 = layer[i][j];
        if (j > 0) {
          l1 = layer[i][j - 1];
          if (dis[l1][l2] > 2)
            for (j2++; j2 < a[i - 1] && isLeaf[layer[i - 1][j2]]; j2++);
        } else {
          for (; j2 < a[i - 1] && isLeaf[layer[i - 1][j2]]; j2++);
        }
        fa[l2] = layer[i - 1][j2];

        for (i3 = 1; i3 <= n; i3++)
          if (dis[l2][i3] > 0)
            dis[fa[l2]][i3] = dis[i3][fa[l2]] = dis[l2][i3] - 1;
      }
    }

    System.out.print(fa[1]);
    for (i = 2; i <= n; i++)
      System.out.print(" " + fa[i]);
    System.out.println();
  }
}
