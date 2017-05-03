import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by yfy on 2017/2/22.
 */
public class P3 {
  private static PrintStream ps;

  public static void main(String[] args) throws Exception {
    Scanner scan = new Scanner(new File("C-small-practice.in"));
    int t = scan.nextInt();
    ps = new PrintStream("C-small-practice.out");
    for (int i = 1; i <= t; i++) {
      ps.print("Case #" + i + ": ");
      solve(scan.nextInt(), scan.nextInt());
    }
  }

  private static void solve(int l, int r) {
    int ans = 0;
    int min = Math.min(l, r);
    for (int i = 1; i <= min; i++)
      ans += i;
    ps.println(ans);
  }
}
