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
  private static int[] pairs;

  public static void main(String[] args) throws Exception {
    Scanner scan = new Scanner(new File("wormhole.in"));
    n = scan.nextInt();
    Point[] ps = new Point[n];
    pairs = new int[n];
    for (int i = 0; i < n; i++)
      ps[i] = new Point(scan.nextInt(), scan.nextInt());
    use = new boolean[n];
    search(0);
  }

  private static void search(int i) {
    while (i < n && use[i]) i++;
    if (i >= n) {
      System.out.println("count");
      return;
    }
    use[i] = true;
    for (int j = i + 1; j < n; j++) {
      if (use[j]) continue;
      pairs[i] = j;
      pairs[j] = i;
      use[j] = true;
      search(i + 1);
      use[j] = false;
    }
    use[i] = false;
  }

  private static class Point {
    int x, y;
    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
