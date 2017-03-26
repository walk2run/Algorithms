import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by yfy on 2017/3/26.
 */
public class P4 {
  static Scanner scan;

  public static void main(String[] args) {
    scan = new Scanner(System.in);
    int t = scan.nextInt();
    for (int i = 0; i < t; i++)
      solve();
  }

  static void solve() {
    int n = scan.nextInt();
    int m = scan.nextInt();
    Pair[] a = new Pair[n];
    for (int i = 0; i < n; i++) {
      Pair pair = new Pair();
      pair.v = scan.nextInt();
      pair.p = i;
      a[i] = pair;
    }
    Arrays.sort(a, new Comparator<Pair>() {
      @Override
      public int compare(Pair o1, Pair o2) {
        return o1.v - o2.v;
      }
    });
    for (int i = 0; i < m; i++) {
      int l = scan.nextInt() - 1;
      int r = scan.nextInt() - 1;
      int times = r - l + 1;
      long sum = 0;
      for (int j = 0; j < n; j++) {
        if (a[j].p >= l && a[j].p <= r) {
          sum += a[j].v * times;
          times--;
        }
      }
      System.out.println(sum);
    }
  }

  static class Pair {
    int v, p;
  }
}
