import java.util.Scanner;

/**
 * Created by yfy on 2017/4/14.
 */
public class P2 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    long n = scan.nextLong();
    long q = scan.nextLong();
    long r = 1, t0 = 0, min = Long.MAX_VALUE;
    for (int i = 0; i < 45; i++) {
      long t1 = n % r == 0 ? n / r : n / r + 1;
      if (t0 + t1 <= min)
        min = t0 + t1;
      else
        break;
      r <<= 1;
      t0 += q;
    }
    System.out.println(min);
  }
}