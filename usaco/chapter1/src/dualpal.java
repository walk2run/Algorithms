/*
ID: iamyfy1
PROG: dualpal
LANG: JAVA
 */
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by yfy on 2016/11/2.
 */
public class dualpal {
  public static void main(String[] args) throws Exception {
    int n, s, i, count, b, palCount;
    Scanner scanner = new Scanner(new File("dualpal.in"));
    n = scanner.nextInt();
    s = scanner.nextInt();
    PrintWriter pw = new PrintWriter("dualpal.out");
    count = 0;
    for (i = s + 1; count < n; i++) {
      palCount = 0;
      for (b = 2; b <= 10 && palCount < 2; b++)
        if (pal(trans(i, b))) palCount++;
      if (palCount == 2) {
        pw.println(i);
        count++;
      }
    }
    pw.close();
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
