/*
ID: iamyfy1
PROG: wormhole
LANG: JAVA
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by yfy on 16-11-30.
 * Wormholes
 */
public class wormhole {
  private static int n, count;
  private static boolean[] use;
  private static int[] pairs, right;
  private static Point[] points;

  public static void main(String[] args) throws Exception {
    Scanner scan = new Scanner(new File("wormhole.in"));
    n = scan.nextInt();
    points = new Point[n];
    pairs = new int[n];
    for (int i = 0; i < n; i++)
      points[i] = new Point(scan.nextInt(), scan.nextInt());

    right = new int[n];
    Arrays.fill(right, -1);
    for (int i = 0; i < n; i++)
      for (int j = 0; j < n; j++)
        if (points[j].x > points[i].x && points[j].y == points[i].y &&
            (right[i] == -1 || points[j].x < points[right[i]].x))
          right[i] = j;

    use = new boolean[n];
    search(0);

    PrintWriter pw = new PrintWriter("wormhole.out");
    pw.println(count);
    pw.close();
  }

  private static void search(int i) {
    while (i < n && use[i]) i++;
    if (i >= n) {
      //System.out.println(Arrays.toString(pairs));
      if (check()) count++;
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

  private static boolean check() {
    for (int i = 0; i < n; i++) {
      int p = i;
      for (int j = 0; j < n; j++) {
        if (p == -1) break;
        p = right[pairs[p]];
      }
      if (p != -1) return true;
    }
    return false;
  }

  private static class Point {
    int x, y;
    Point(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
