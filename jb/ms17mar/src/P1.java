import java.util.Scanner;

/**
 * Created by yfy on 2017/4/11.
 */
public class P1 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    double p = scan.nextInt();
    double q = scan.nextInt() / 100.0;
    int n = scan.nextInt();

    double sum = 0;
    for (int i = 0; i < n; i++) {
      double cp = Math.floor(p) / 100;
      double pos = cp;
      double fac = 1 - cp;
      int j = 1;
      while (cp < 1) {
        j++;
        cp += q;
        if (cp > 1) cp = 1;
        pos += j * fac * cp;
        fac *= 1 - cp;
      }
      sum += pos;
      p /= 2;
    }
    System.out.printf("%.2f\n", sum);
  }
}