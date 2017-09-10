import java.util.List;
import java.util.Scanner;

public class P2 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    for (int i = 0; i < t; i++)
      solve(scan);
  }

  static void solve(Scanner scan) {
    int n = scan.nextInt();
    int m = scan.nextInt();
    int k = scan.nextInt();
    int[] v = new int[n];
    int[] p = new int[n];
    int[] t = new int[n];
    int[] jvs = new int[m]; // jarvis

    for (int i = 0; i < n; i++) {
      v[i] = scan.nextInt();
      p[i] = scan.nextInt();
      t[i] = scan.nextInt();
      if (t[i] == 1) jvs[p[i] - 1]++;
    }
    int[] c = new int[m];
    for (int i = 0; i < m; i++)
      c[i] = scan.nextInt();

    int[][] d = new int[m][k + 1];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j <= k; j++) {
        int max = 0;
        for (int a = 0; a <= jvs[i]; a++) {
          //if (d[i - 1][j - a] + )
        }
      }
    }
  }
}
