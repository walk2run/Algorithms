/*
ID: iamyfy1
PROG: crypt1
LANG: JAVA
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by yfy on 11/29/16.
 * Prime Cryptarithm
 */
public class crypt1 {
  private static int[] d;

  public static void main(String[] args) throws Exception {
    Scanner scan = new Scanner(new File("crypt1.in"));
    int n = scan.nextInt();
    d = new int[n];
    for (int i = 0; i < n; i++)
      d[i] = scan.nextInt();
    int count = 0;
    for (int i1 = 0; i1 < n; i1++)
      for (int i2 = 0; i2 < n; i2++)
        for (int i3 = 0; i3 < n; i3++)
          for (int i4 = 0; i4 < n; i4++)
            for (int i5 = 0; i5 < n; i5++)
              if (check(d[i1], d[i2], d[i3], d[i4], d[i5]))
                count++;
    PrintWriter pw = new PrintWriter("crypt1.out");
    pw.println(count);
    pw.close();
  }

  private static boolean check(int a, int b, int c, int d, int e) {
    int f1 = a * 100 + b * 10 + c;
    int p1 = f1 * e;
    int p2 = f1 * d;
    int sum = p1 + p2 * 10;
    return valid(p1, 3) && valid(p2, 3) && valid(sum, 4);
  }

  private static boolean valid(int num, int w) {
    if (w == 3 && num >= 100 && num <= 999 || w == 4 && num >= 1000 && num <= 9999) {
      while (num > 0) {
        if (!in(num % 10)) return false;
        num /= 10;
      }
      return true;
    }
    return false;
  }

  private static boolean in(int digit) {
    for (int d0 : d)
      if (digit == d0) return true;
    return false;
  }
}
