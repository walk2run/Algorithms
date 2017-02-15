import java.util.Scanner;

/**
 * Created by yfy on 2/15/2017.
 */
public class P4 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    double ans = 0;
    if (n == 1) ans = 1;
    if (n == 2) ans = 1.5;
    if (n == 3) ans = 1.75;
    System.out.printf("%.4f", ans);
  }
}
