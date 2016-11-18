/*
ID: iamyfy1
PROG: transform
LANG: JAVA
 */

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by yfy on 2016/10/31.
 */
public class transform {
  private static int n;

  public static void main(String[] args) throws Exception {
    int i, j, id;
    Scanner scanner = new Scanner(new BufferedInputStream(new FileInputStream("transform.in")));
    n = scanner.nextInt();
    char[][] a = new char[n][n];
    char[][] b = new char[n][n];
    for (i = 0; i < n; i++) {
      String line = scanner.next();
      for (j = 0; j < n; j++)
        a[i][j] = line.charAt(j);
    }
    for (i = 0; i < n; i++) {
      String line = scanner.next();
      for (j = 0; j < n; j++)
        b[i][j] = line.charAt(j);
    }

    if (match(rotate(a), b))
      id = 1;
    else if (match(rotate2(a), b))
      id = 2;
    else if (match(rotate3(a), b))
      id = 3;
    else if (match(reflect(a), b))
      id = 4;
    else if (match(rotate(reflect(a)), b) ||
        match(rotate2(reflect(a)), b) || match(rotate3(reflect(a)), b))
      id = 5;
    else if (match(a, b))
      id = 6;
    else
      id = 7;

    PrintWriter pw = new PrintWriter("transform.out");
    pw.println(id);
    pw.close();
  }

  private static char[][] rotate(char[][] a) {
    char[][] b = new char[n][n];
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        b[j][n - i - 1] = a[i][j];
    return b;
  }

  private static char[][] rotate2(char[][] a) {
    return rotate(rotate(a));
  }

  private static char[][] rotate3(char[][] a) {
    return rotate(rotate(rotate(a)));
  }

  private static char[][] reflect(char[][] a) {
    char[][] b = new char[n][n];
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        b[i][j] = a[i][n - j - 1];
    return b;
  }

  private static boolean match(char[][] a, char[][] b) {
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        if (a[i][j] != b[i][j]) return false;
    return true;
  }
}
