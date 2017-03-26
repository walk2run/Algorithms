import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by yfy on 2017/3/26.
 */
public class P3 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int count, area, len;
    count = area = len = 0;
    Map<Pair, Integer> map = new HashMap<>();
    int[] fa = new int[n];
    Pair pair = new Pair(0, 0);
    for (int i = 0; i < n; i++) {
      int x = scan.nextInt();
      int y = scan.nextInt();
      map.put(new Pair(x, y), i);
      fa[i] = -1;

      area++;
      count++;
      len += 4;

      Integer num;
      pair.set(x - 1, y);
      num = map.get(pair);
      if (num != null) {
        len -= 2;
        if (merge(fa, num, i)) count--;
      }

      pair.set(x + 1, y);
      num = map.get(pair);
      if (num != null) {
        len -= 2;
        if (merge(fa, num, i)) count--;
      }

      pair.set(x, y - 1);
      num = map.get(pair);
      if (num != null) {
        len -= 2;
        if (merge(fa, num, i)) count--;
      }

      pair.set(x, y + 1);
      num = map.get(pair);
      if (num != null) {
        len -= 2;
        if (merge(fa, num, i)) count--;
      }

      System.out.println(count + " " + area + " " + len);
    }
  }

  static boolean merge(int[] fa, int x, int y) {
    while (fa[x] >= 0) x = fa[x];
    while (fa[y] >= 0) y = fa[y];
    if (x == y) return false;
    int hx = -fa[x];
    int hy = -fa[y];
    if (hx == hy) {
      fa[x] = y;
      fa[y]--;
    } else if (hx > hy) {
      fa[y] = x;
    } else {
      fa[x] = y;
    }
    return true;
  }

  static class Pair {
    int x, y;
    Pair(int x, int y) {
      this.x = x;
      this.y = y;
    }
    void set(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public int hashCode() {
      return x * 1000 + y;
    }

    @Override
    public boolean equals(Object obj) {
      Pair pair = (Pair) obj;
      return pair.x == x && pair.y == y;
    }
  }
}
