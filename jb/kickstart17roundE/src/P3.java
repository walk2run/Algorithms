import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by yfy on 8/27/17.
 */
public class P3 {
  public static void main(String[] args) throws Exception {
    Scanner scan = new Scanner(new File("C-small-attempt0.in"));
    int t = scan.nextInt();
    PrintWriter pw = new PrintWriter("C-small.out");
    for (int i = 1; i <= t; i++)
      pw.printf("Case #%d: %.9f\n", i, solveSmall(scan));
    pw.close();
  }

  static double solveSmall(Scanner scan) {
    int[] x = new int[9];
    for (int i = 0; i < 9; i++)
      x[i] = scan.nextInt();
    int xMax = Math.max(x[0], Math.max(x[3], x[6]));
    int xMin = Math.min(x[0], Math.min(x[3], x[6]));
    return (xMax - xMin) / 6.0;
  }
}
