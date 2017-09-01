import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class P3 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    times = new int[n];
    for (int i = 0; i < n; i++)
      times[i] = scan.nextInt();
    children = new ArrayList[n];
    for (int i = 0; i < n; i++)
      children[i] = new ArrayList<>();
    int[] roots = new int[n];
    Arrays.fill(roots, -1);
    for (int i = 0; i < n - 1; i++) {
      int a = scan.nextInt() - 1;
      int b = scan.nextInt() - 1;
      children[a].add(b);
      roots[b] = a;
    }
    int root = 0;
    while (roots[root] >= 0) root = roots[root];
    chm = new long[n];
    dfs(root, 0);
    solve(root, max);
    System.out.println(ans);
  }

  static int[] times;
  static List<Integer>[] children;
  static long max, ans;
  static long[] chm;

  static long dfs(int node, long sum) {
    sum += times[node];
    max = Math.max(sum, max);
    long childMax = 0;
    for (int child : children[node])
      childMax = Math.max(childMax, dfs(child, sum));
    chm[node] = childMax;
    return childMax + times[node];
  }

  static void solve(int node, long remain) {
    remain -= times[node];
    if (remain > chm[node]) {
      ans += remain - chm[node];
      remain = chm[node];
    }
    for (int child : children[node])
      solve(child, remain);
  }
}
