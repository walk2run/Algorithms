/*
ID: iamyfy1
PROG: palsquare
LANG: JAVA
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by yfy on 2016/11/2.
 */
public class palsquare {
  private static PrintWriter pw;

  public static void main(String[] args) throws Exception {
    int n, b;
    Scanner scanner = new Scanner(new File("palsquare.in"));
    b = scanner.nextInt();
    pw = new PrintWriter("palsquare.out");
    for (n = 1; n <= 300; n++)
      deal(n, b);
    pw.close();
  }

  private static void deal(int n, int b) {
    String sqr = trans(n * n, b);
    if (pal(sqr)) {
      String nb = trans(n, b);
      pw.println(nb + ' ' + sqr);
    }
  }

  private static String trans(int n, int b) {
    StringBuilder sb = new StringBuilder();
    while (n > 0) {
      int r = n % b;
      if (r < 10)
        sb.append((char)('0' + r));
      else
        sb.append((char)('A' + r - 10));
      n = n / b;
    }
    return sb.reverse().toString();
  }

  private static boolean pal(String str) {
    int i, len;
    len = str.length();
    for (i = 0; i < len / 2; i++)
      if (str.charAt(i) != str.charAt(len - 1 - i))
        return false;
    return true;
  }
}
