import java.util.Scanner;

/**
 * Created by yfy on 2017/4/14.
 */
public class P4 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int[] fas = new int[n + 1];
    int[] ins = new int[n + 1];
    int[] ips = new int[n + 1];
    int[] costs = new int[n + 1];
    int[][] children = new int[n + 1][2000];
    int root = 1;
    for (int i = 1; i <= n; i++) {
      fas[i] = scan.nextInt();
      ins[i] = scan.nextInt();
      ips[i] = scan.nextInt();
      costs[i] = scan.nextInt();
      if (fas[i] == 0) root = i;
    }
    System.out.println(kill(root));
  }

  private static int kill(int p) {
    
  }
}
