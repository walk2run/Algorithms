import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P2 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    edges = new List[n];
    for (int i = 0; i < n; i++)
      edges[i] = new ArrayList<>();
    for (int i = 0; i < n - 1; i++) {
      int a = scan.nextInt() - 1;
      int b = scan.nextInt() - 1;
      edges[a].add(b);
      edges[b].add(a);
    }
    use = new boolean[n];
    dfs(0);
    System.out.println(ans);
  }

  static List<Integer>[] edges;
  static boolean[] use;
  static int ans;

  static int dfs(int node) {
    use[node] = true;
    int sum = 1;
    for (int child : edges[node]) {
      if (!use[child]) {
        int num = dfs(child);
        if (num % 2 == 0) ans++;
        sum += num;
      }
    }
    use[node] = false;
    return sum;
  }
}
