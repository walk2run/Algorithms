import java.util.Scanner;

public class P1 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    for (int i = 0; i < t; i++)
      System.out.printf("%.4f\n", solve(scan));
  }

  static double solve(Scanner scan) {
    int h = scan.nextInt();
    int m = scan.nextInt();
    int s = scan.nextInt();
    int t = scan.nextInt();

    t += h * 3600 + m * 60 + s;
    t %= 12 * 3600;
    double ha = t / (12.0 * 3600) * 360;
    double ma = t % 3600 / 3600.0 * 360;
    double angle = Math.abs(ha - ma);
    if (angle > 180) angle = 360 - angle;
    return angle;
  }
}
