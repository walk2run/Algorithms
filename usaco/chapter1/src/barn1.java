/*
ID: iamyfy1
PROG: barn1
LANG: JAVA
 */

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yfy on 16-11-18.
 * Barn Repair
 */
public class barn1 {
  public static void main(String[] args) throws Exception {
    int m, s, c, i, sum;
    Scanner scan = new Scanner(new BufferedInputStream(new FileInputStream("barn1.in")));
    m = scan.nextInt();
    s = scan.nextInt();
    c = scan.nextInt();
    PrintWriter pw = new PrintWriter("barn1.out");
    if (c <= m) {
      pw.println(c);
      pw.close();
      return;
    }
    List<Integer> stalls = new ArrayList<>();
    for (i = 0; i < c; i++)
      stalls.add(scan.nextInt());
    stalls.sort(null);
    List<Integer> intervals = new ArrayList<>();
    for (i = 1; i < c; i++)
      intervals.add(stalls.get(i) - stalls.get(i - 1));
    intervals.sort((o1, o2) -> o2 - o1);
    sum = 0;
    for (i = 0; i < m - 1; i++)
      sum += intervals.get(i);
    pw.println(stalls.get(c - 1) - stalls.get(0) + 1 - sum);
    pw.close();
  }
}
