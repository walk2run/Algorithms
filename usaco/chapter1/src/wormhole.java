/*
ID: iamyfy1
PROG: wormhole
LANG: JAVA
 */

import java.io.File;
import java.util.Scanner;

/**
 * Created by yfy on 16-11-30.
 * Wormholes
 */
public class wormhole {
  private static int n;
  private static boolean[] use;

  public static void main(String[] args) throws Exception {
    Scanner scan = new Scanner(new File("wormhole.in"));
    n = scan.nextInt();
    Point[] ps = new Point[n];
    for (int i = 0; i < n; i++)
      ps[i] = new Point(scan.nextInt(), scan.nextInt());
    use = new boolean[n];
    search(0);
  }

  private static void search(int i) {
    while (i < n && use[i]) i++;
    if (i < n) use[i] = true; else return;
    int j = i + 1;
    while (j < n && use[j]) j++;
    if (j < n) use[j] = true;
    search(i + 1);
  }

  private static class Point {
    int x, y;
    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
