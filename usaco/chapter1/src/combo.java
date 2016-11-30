/*
ID: iamyfy1
PROG: combo
LANG: JAVA
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by yfy on 16-11-30.
 * Combination Lock
 */
public class combo {
  private static int n;

  private static Set<Tuple> set = new HashSet<>();

  public static void main(String[] args) throws Exception {
    Scanner scan = new Scanner(new File("combo.in"));
    n = scan.nextInt();
    add(scan.nextInt(), scan.nextInt(), scan.nextInt());
    add(scan.nextInt(), scan.nextInt(), scan.nextInt());
    PrintWriter pw = new PrintWriter("combo.out");
    pw.println(set.size());
    pw.close();
  }

  private static void add(int a, int b, int c) {
    for (int i = a - 2; i <= a + 2; i++) {
      int d1 = f(i);
      if (d1 < 1 || d1 > n) continue;
      for (int j = b - 2; j <= b + 2; j++) {
        int d2 = f(j);
        if (d2 < 1 || d2 > n) continue;
        for (int k = c - 2; k <= c + 2; k++) {
          int d3 = f(k);
          if (d3 < 1 || d3 > n) continue;
          set.add(new Tuple(d1, d2, d3));
        }
      }
    }
  }

  private static int f(int i) {
    if (i < 1) return i + n;
    if (i > n) return i - n;
    return i;
  }

  private static class Tuple {
    int a, b, c;

    Tuple(int a, int b, int c) {
      this.a = a;
      this.b = b;
      this.c = c;
    }

    @Override
    public int hashCode() {
      return a * 32 * 32 + b * 32 + c;
    }

    @Override
    public boolean equals(Object obj) {
      if (obj instanceof Tuple) {
        Tuple t = (Tuple) obj;
        return t.a == a && t.b == b && t.c == c;
      }
      return false;
    }
  }
}
