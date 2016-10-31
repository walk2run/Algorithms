/*
ID: iamyfy1
PROG: beads
LANG: JAVA
 */

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by yfy on 2016/10/31.
 * Dynamic programming
 */
public class beads {
  public static void main(String[] args) throws Exception {
    int n, i, j, max;
    int[] lr, lb, rr, rb;
    Scanner scan = new Scanner(new BufferedInputStream(new FileInputStream("beads.in")));
    n = scan.nextInt();
    String beads = scan.next();
    lr = new int[n];
    lb = new int[n];
    rr = new int[n];
    rb = new int[n];
    for (j = 0; j < 2; j++) {
      for (i = 0; i < n; i++) {
        if (beads.charAt(i) == 'w') {
          if (i == 0) {
            lr[i] = lr[n - 1] + 1;
            lb[i] = lb[n - 1] + 1;
          } else {
            lr[i] = lr[i - 1] + 1;
            lb[i] = lb[i - 1] + 1;
          }
        } else if (beads.charAt(i) == 'r') {
          if (i == 0)
            lr[i] = lr[n - 1] + 1;
          else
            lr[i] = lr[i - 1] + 1;
        } else {
          if (i == 0)
            lb[i] = lb[n - 1] + 1;
          else
            lb[i] = lb[i - 1] + 1;
        }
      }
    }
    for (j = 0; j < 2; j++) {
      for (i = n - 1; i >= 0; i--) {
        if (beads.charAt(i) == 'w') {
          if (i == n - 1) {
            rr[i] = rr[0] + 1;
            rb[i] = rb[0] + 1;
          } else {
            rr[i] = rr[i + 1] + 1;
            rb[i] = rb[i + 1] + 1;
          }
        } else if (beads.charAt(i) == 'r') {
          if (i == n - 1)
            rr[i] = rr[0] + 1;
          else
            rr[i] = rr[i + 1] + 1;
        } else {
          if (i == n - 1)
            rb[i] = rb[0] + 1;
          else
            rb[i] = rb[i + 1] + 1;
        }
      }
    }
    max = 0;
    for (i = 0; i < n - 1; i++)
      max = Math.max(max, Math.max(lr[i], lb[i]) + Math.max(rr[i + 1], rb[i + 1]));
    max = Math.max(max, Math.max(lr[n - 1], lb[n - 1]) + Math.max(rr[0], rb[0]));
    max = Math.min(max, n);
    PrintWriter writer = new PrintWriter("beads.out");
    writer.println(max);
    writer.close();
  }
}
