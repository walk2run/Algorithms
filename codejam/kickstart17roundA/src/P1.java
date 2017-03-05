import java.io.File;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by yfy on 2017/3/5.
 */
public class P1 {
  private static PrintStream ps;

  public static void main(String[] args) throws Exception {
    Scanner scan = new Scanner(new File("A-large.in"));
    int t = scan.nextInt();
    ps = new PrintStream("A-large.out");
    for (int i = 1; i <= t; i++) {
      ps.print("Case #" + i + ": ");
      solve(scan.nextInt(), scan.nextInt());
    }
  }

  private static void solve(int n, int m) {
//    long sum = 0;
//    for (int i = 1; i < Math.min(n, m); i++)
//      sum = (sum + (n - i) * (m - i) % 1000000007 * i % 1000000007) % 1000000007;
//    ps.println(sum);

    long sum = 0;
    for (int i = 1; i < Math.min(n, m); i++) {
      long pro = BigInteger.valueOf(n - i).multiply(BigInteger.valueOf(m - i)).multiply(BigInteger.valueOf(i)).mod(BigInteger.valueOf(1000000007)).longValue();
      sum = (sum + pro) % 1000000007;
    }
    ps.println(sum);
    System.out.println(sum);
  }
}
