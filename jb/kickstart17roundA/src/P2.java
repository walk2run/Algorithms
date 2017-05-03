import java.io.File;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by yfy on 2017/3/5.
 */

class Tuple {
  int a, b, c, d;

  public Tuple(int a, int b, int c, int d) {
    this.a = a;
    this.b = b;
    this.c = c;
    this.d = d;
  }

  @Override
  public int hashCode() {
    return a * 1000 + b * 100 + c * 10 + d;
  }

  @Override
  public boolean equals(Object obj) {
    Tuple t = (Tuple) obj;
    return a == t.a && b == t.b && c == t.c && d == t.d;
  }
}

public class P2 {
  private static PrintStream ps;
  private static String a, b;
  private static int n, m;
  private static Map<Tuple, Boolean> map;

  public static void main(String[] args) throws Exception {
    Scanner scan = new Scanner(new File("B-large.in"));
    int t = scan.nextInt();
    ps = new PrintStream("B-large.out");
    for (int i = 1; i <= t; i++) {
      ps.print("Case #" + i + ": ");
      a = scan.next();
      b = scan.next();
      n = a.length();
      m = b.length();
      map = new HashMap<>();
      ps.println(solve(0, 0, 0, 0) ? "TRUE" : "FALSE");
    }
  }

  private static boolean solve(int i, int j, int use1, int use2) {
    Boolean bool = map.get(new Tuple(i, j, use1, use2));
    if (bool != null) return bool;
    if (i == n && j == m) {
      map.put(new Tuple(i, j, use1, use2), true);
      return true;
    }
    if (i == n)
      return j < m && b.charAt(j) == '*' && solve(i, j + 1, use1, 0);
    if (j == m)
      return i < n && a.charAt(i) == '*' && solve(i + 1, j, 0, use2);
    if (i > n || j > m) {
      map.put(new Tuple(i, j, use1, use2), false);
      return false;
    }
    char c1 = a.charAt(i), c2 = b.charAt(j);
    if (c1 == '*') {
      if (solve(i + 1, j, 0, use2)) {
        map.put(new Tuple(i, j, use1, use2), true);
        return true;
      }
      if (c2 == '*') {
        if (solve(i, j + 1, use1, 0)) {
          map.put(new Tuple(i, j, use1, use2), true);
          return true;
        }
      } else {
        if (use1 < 4 && solve(i, j + 1, use1 + 1, 0)) {
          map.put(new Tuple(i, j, use1, use2), true);
          return true;
        }
      }
    }
    if (c2 == '*') {
      if (solve(i, j + 1, use1, 0)) {
        map.put(new Tuple(i, j, use1, use2), true);
        return true;
      }
      if (c1 == '*') {
        if (solve(i + 1, j, 0, use2)) {
          map.put(new Tuple(i, j, use1, use2), true);
          return true;
        }
      } else {
        if (use2 < 4 && solve(i + 1, j, 0, use2 + 1)) {
          map.put(new Tuple(i, j, use1, use2), true);
          return true;
        }
      }
    }
    if (c1 == c2 && c1 != '*') {
      boolean b = solve(i + 1, j + 1, 0, 0);
      map.put(new Tuple(i, j, use1, use2), b);
      return b;
    }
    map.put(new Tuple(i, j, use1, use2), false);
    return false;
  }

  private static boolean solve2(int i, int j) {
    if (i == n && j == m) return true;
    if (i == n)
      return j < m && b.charAt(j) == '*' && solve2(i, j + 1);
    if (j == m)
      return i < n && a.charAt(i) == '*' && solve2(i + 1, j);
    if (i > n || j > m) return false;
    char c1 = a.charAt(i), c2 = b.charAt(j);
    if (c1 == '*' && c2 == '*') {
      if (solve2(i + 1, j + 1)) return true;
      if (solve2(i + 2, j + 1)) return true;
      if (solve2(i + 3, j + 1)) return true;
      if (solve2(i + 4, j + 1)) return true;
      if (solve2(i + 5, j + 1)) return true;
      if (solve2(i + 1, j + 2)) return true;
      if (solve2(i + 1, j + 3)) return true;
      if (solve2(i + 1, j + 4)) return true;
      if (solve2(i + 1, j + 5)) return true;
      return false;
    }
    if (c1 == '*') {
      if (solve2(i + 1, j)) return true;
      if (solve2(i + 1, j + 1)) return true;
      if (solve2(i + 1, j + 2)) return true;
      if (solve2(i + 1, j + 3)) return true;
      if (solve2(i + 1, j + 4)) return true;
      return false;
    }
    if (c2 == '*') {
      if (solve2(i, j + 1)) return true;
      if (solve2(i + 1, j + 1)) return true;
      if (solve2(i + 2, j + 1)) return true;
      if (solve2(i + 3, j + 1)) return true;
      if (solve2(i + 4, j + 1)) return true;
      return false;
    }
    if (c1 == c2)
      return solve2(i + 1, j + 1);
    return false;
  }
}
