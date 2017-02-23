import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * Created by yfy on 2017/2/23.
 */
public class P2 {
  private static PrintStream ps;

  public static void main(String[] args) throws Exception {
    Scanner scan = new Scanner(new File("B-small-practice.in"));
    int t = scan.nextInt();
    ps = new PrintStream("B-small-practice.out");
    for (int i = 1; i <= t; i++) {
      ps.print("Case #" + i + ": ");
      solve(scan.nextInt(), scan.nextInt());
    }
  }

  private static void solve(int m, int n) {
    
  }
}
