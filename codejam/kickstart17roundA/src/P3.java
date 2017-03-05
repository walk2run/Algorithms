import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by yfy on 2017/3/5.
 */
public class P3 {
  private static Scanner scan;
  private static PrintStream ps;

  public static void main(String[] args) throws Exception {
    scan = new Scanner(new File("A-large.in"));
    int t = scan.nextInt();
    ps = new PrintStream("A-large.out");
    for (int i = 1; i <= t; i++) {
      ps.print("Case #" + i + ": ");
      solve();
    }
  }

  private static void solve() {

  }

}
