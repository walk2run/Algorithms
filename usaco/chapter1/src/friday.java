/*
ID: iamyfy1
PROG: friday
LANG: JAVA
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by yfy on 2016/10/31.
 */
public class friday {
  public static void main(String[] args) throws Exception {
    int n, i, j, day;
    int d[] = new int[7];
    int days[] = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    Scanner scan = new Scanner(new File("friday.in"));
    n = scan.nextInt();
    day = 13 % 7;
    for (i = 1900; i < 1900 + n; i++) {
      for (j = 0; j < 12; j++) {
        d[day]++;
        if (j == 1 && leap(i))
          day += 29;
        else
          day += days[j];
        day %= 7;
      }
    }
    PrintWriter writer = new PrintWriter("friday.out");
    writer.printf("%d %d %d %d %d %d %d\n", d[6], d[0], d[1], d[2], d[3], d[4], d[5]);
    writer.close();
  }

  private static boolean leap(int y) {
    return y % 400 == 0 || (y % 100 != 0 && y % 4 == 0);
  }
}
