import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by yfy on 2017/3/16.
 */
public class Main {
  public static void main(String[] args) {
    int[] tree = new int[32];
    Arrays.fill(tree, -1);
    int[] off = new int[]{0, 0, 1, 3, 7};
    Scanner scan = new Scanner(System.in);
    while (scan.hasNextInt()) {
      int n = scan.nextInt();
      if (n == 0) break;
      int l = n / 100;
      int p = n % 100 / 10;
      int v = n % 10;
      tree[off[l] + p - 1] = v;
    }
    dfs(tree, 0, 0);
    System.out.println(ans);
  }

  private static int ans;

  private static void dfs(int[] tree, int i, int sum) {
    if (tree[i] == -1) return;
    sum += tree[i];
    int left = i * 2 + 1, right = i * 2 + 2;
    if (tree[left] == -1 && tree[right] == -1)
      ans += sum;
    else {
      dfs(tree, left, sum);
      dfs(tree, right, sum);
    }
  }
}
