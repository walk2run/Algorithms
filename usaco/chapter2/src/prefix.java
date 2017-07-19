/*
ID: iamyfy1
PROG: prefix
LANG: JAVA
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yfy on 7/19/17.
 */
public class prefix {
  public static void main(String[] args) throws Exception {
    Scanner scan = new Scanner(new File("prefix.in"));
    List<String> tokens = new ArrayList<>();
    int maxLen = 0;
    String token;
    while (!(token = scan.next()).equals(".")) {
      tokens.add(token);
      maxLen = Math.max(token.length(), maxLen);
    }
    StringBuilder sb = new StringBuilder();
    while (scan.hasNext())
      sb.append(scan.next());
    String seq = sb.toString();

    int n = seq.length();
    boolean[] f = new boolean[n];
    for (int i = 0; i < n; i++) {
      for (String t : tokens) {
        int len = t.length();
        int prev = i - len;
        if (prev < -1 || prev > -1 && !f[prev]) continue;
        if (seq.substring(prev + 1, prev + 1 + len).equals(t)) {
          f[i] = true;
          break;
        }
      }
    }
    int i = n - 1;
    while (i >= 0 && !f[i]) i--;

    PrintWriter pw = new PrintWriter("prefix.out");
    pw.println(i + 1);
    pw.close();
  }
}
