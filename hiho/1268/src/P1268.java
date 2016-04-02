import java.util.Scanner;

/**
 * Created by yfy on 3/19/16.
 * 九宫
 */

public class P1268 {
  public static void main(String[] args) {
    new P1268().run();
  }

  void run() {
    int i;
    int[] d = new int[9], ansOut = null;
    int[][] anss = new int[][]{
        {4, 9, 2, 3, 5, 7, 8, 1, 6},
        {8, 3, 4, 1, 5, 9, 6, 7, 2},
        {6, 1, 8, 7, 5, 3, 2, 9, 4},
        {2, 7, 6, 9, 5, 1, 4, 3, 8},
        {2, 9, 4, 7, 5, 3, 6, 1, 8},
        {6, 7, 2, 1, 5, 9, 8, 3, 4},
        {8, 1, 6, 3, 5, 7, 4, 9, 2},
        {4, 3, 8, 9, 5, 1, 2, 7, 6}};

    Scanner scanner = new Scanner(System.in);
    for (i = 0; i < 9; i++)
      d[i] = scanner.nextInt();
    for (int[] ans : anss) {
      if (equal(ans, d))
        if (ansOut == null) {
          ansOut = ans;
        } else {
          ansOut = null;
          break;
        }
    }
    if (ansOut == null)
      System.out.println("Too Many");
    else
      System.out.printf("%d %d %d\n%d %d %d\n%d %d %d\n",
          ansOut[0], ansOut[1], ansOut[2],
          ansOut[3], ansOut[4], ansOut[5],
          ansOut[6], ansOut[7], ansOut[8]);
  }

  boolean equal(int[] a, int[] b) {
    for (int i = 0; i < 9; i++)
      if (a[i] != b[i] && b[i] != 0)
        return false;
    return true;
  }
}
