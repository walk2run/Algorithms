import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by yfy on 7/16/17.
 */
public class P1 {
  final static int MAX = 1000000001;
  static Scanner scan;

  public static void main(String[] args) throws Exception {
    scan = new Scanner(new File("A-large.in"));
    int t = scan.nextInt();
    PrintWriter pw = new PrintWriter("A-large.out");
    for (int i = 1; i <= t; i++) {
      pw.printf("Case #%d: ", i);
      int ans = solve();
      pw.println(ans == -1 ? "IMPOSSIBLE" : ans);
    }
    pw.close();
  }

  static int solve() {
    int n = scan.nextInt();
    int ts = scan.nextInt();
    int tf = scan.nextInt();
    int[] s = new int[2000]; // start
    int[] f = new int[2000]; // frequency
    int[] d = new int[2000]; // duration
    for (int i = 0; i < n - 1; i++) {
      s[i] = scan.nextInt();
      f[i] = scan.nextInt();
      d[i] = scan.nextInt();
    }
    int[][] time = new int[2000][2000];
    time[0][1] = ts;
    for (int i = 1; i < n - 1; i++) {
      for (int j = 0; j <= i + 1; j++) {
        int time0, time1;
        if (j > 0) {
          time0 = time[i - 1][j - 1];
          time0 = busTime(time0, s[i - 1], f[i - 1], d[i - 1]);
          if (time0 > tf || time0 < 0) time0 = MAX;
          time0 += ts;
          if (time0 > tf || time0 < 0) time0 = MAX;
        } else
          time0 = MAX;
        if (j <= i) {
          time1 = time[i - 1][j];
          time1 = busTime(time1, s[i - 1], f[i - 1], d[i - 1]);
          if (time1 > tf || time1 < 0) time1 = MAX;
        } else
          time1 = MAX;
        time[i][j] = Math.min(time0, time1);
      }
    }
    for (int i = n - 1; i >= 0; i--) {
      int t = busTime(time[n - 2][i], s[n - 2], f[n - 2], d[n - 2]);
      if (t >= 0 && t <= tf) return i;
    }
    return -1;
  }

  static int busTime(int t, int s, int f, int d) {
    if (t <= s) return s + d;
    int a = (t - s) % f;
    if (a == 0)
      return t + d;
    return t + f - a + d;
  }
}
