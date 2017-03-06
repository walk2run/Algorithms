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
    Scanner scan = new Scanner(new File("A-large-practice.in"));
    int t = scan.nextInt();
    ps = new PrintStream("A-large.out");
    for (int i = 1; i <= t; i++) {
      ps.print("Case #" + i + ": ");
      long ans = solve(scan.nextInt(), scan.nextInt());
      ps.println(ans);
      System.out.println(ans);
    }
  }

//  private static void solve(int n, int m) {
//    long sum = 0;
//    for (int i = 1; i < Math.min(n, m); i++)
//      sum = (sum + (n - i) * (m - i) % 1000000007 * i % 1000000007) % 1000000007;
////    ps.println(sum);
//
////    long sum = 0;
////    for (int i = 1; i < Math.min(n, m); i++) {
////      long pro = BigInteger.valueOf(n - i).multiply(BigInteger.valueOf(m - i)).multiply(BigInteger.valueOf(i)).mod(BigInteger.valueOf(1000000007)).longValue();
////      sum = (sum + pro) % 1000000007;
////    }
//    ps.println(sum);
//    System.out.println(sum);
//  }

  private static long solve(long n, long m) {
    n = Math.min(n, m);
    m = Math.max(n, m);
    long a = m - 1, b = 2 * a + 2 * (m - 2), c = b;
    for (long i = 3; i <= n; i++) {
      c = (2 * b - a) % 1000000007 + i * (m - i) % 1000000007;
      a = b;
      b = c;
    }
    return c % 1000000007;
  }
}

class Ulong {
  long a, b;

  void mod() {
    long r = a % 1000000007;
    a = 0;
    b = ((r << 32) + b) % 1000000007;
  }

  void add(Ulong u) {
    b += u.b;
    a += b >> 32;
    b &= 0x00000000ffffffffL;
  }

  void mul(Ulong u) {
    b *= u.b;

  }


}
