/*
ID: iamyfy1
PROG: skidesign
LANG: JAVA
 */

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by yfy on 12/27/16.
 * Ski Course Design
 */
public class skidesign {
  public static void main(String[] args) throws Exception {
    int n, i, max, min, low, high, sum, ans;
    Scanner scan = new Scanner(new BufferedInputStream(new FileInputStream("skidesign.in")));
    n = scan.nextInt();
    int[] h = new int[n];
    max = 0;
    min = 100;
    for (i = 0; i < n; i++) {
      h[i] = scan.nextInt();
      if (h[i] > max) max = h[i];
      if (h[i] < min) min = h[i];
    }
    ans = Integer.MAX_VALUE;
    for (high = max; high >= min + 17; high--) {
      low = high - 17;
      sum = 0;
      for (i = 0; i < n; i++) {
        if (h[i] > high) sum += (high - h[i]) * (high - h[i]);
        else if (h[i] < low) sum += (low - h[i]) * (low - h[i]);
      }
      if (sum < ans) ans = sum;
    }
    if (ans == Integer.MAX_VALUE) ans = 0;
    PrintWriter pw = new PrintWriter("skidesign.out");
    pw.println(ans);
    pw.close();
  }
}
