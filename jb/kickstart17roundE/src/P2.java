import java.io.File;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by yfy on 8/27/17.
 */
public class P2 {
  public static void main(String[] args) throws Exception {
    Scanner scan = new Scanner(new File("B-large.in"));
    int t = scan.nextInt();
    PrintWriter pw = new PrintWriter("B-large.out");
    for (int i = 1; i <= t; i++)
      pw.printf("Case #%d: %d\n", i, solve(scan));
    pw.close();
  }

  static long solveSmall(Scanner scan) {
    int n = scan.nextInt();
    int[] l = new int[n];
    for (int i = 0; i < n; i++)
      l[i] = scan.nextInt();

    long count = 0;
    for (int i0 = 0; i0 < n - 3; i0++)
      for (int i1 = i0 + 1; i1 < n - 2; i1++)
        for (int i2 = i1 + 1; i2 < n - 1; i2++)
          for (int i3 = i2 + 1; i3 < n; i3++) {
            int[] list = new int[]{l[i0], l[i1], l[i2], l[i3]};
            Arrays.sort(list);
            int a = list[0];
            int b = list[1];
            int c = list[2];
            int d = list[3];
            if (can(a, b, c, d) || can(b, c, a, d) || can(c, d, a, b))
              count++;
          }
    return count;
  }

  static boolean can(int a, int b, int c, int d) {
    if (a != b) return false;
    if (c == d) return false;
    return a + b > Math.abs(c - d);
  }

  static long solve(Scanner scan) {
    int n = scan.nextInt();
    int[] l = new int[n];
    for (int i = 0; i < n; i++)
      l[i] = scan.nextInt();
    if (n < 4) return 0;

    Arrays.sort(l);
    int i = 0;
    long count = 0;
    while (i < n - 1) {
      if (l[i] == l[i + 1]) {
        long count1 = 0, count2 = 0;
        int end = i + 2;
        while (end < n && l[end] == l[i]) end++;
        end--;
        int a = 0, b = 1;
        while (a < n - 1) {
          if (a == i || a == i + 1) {
            a++;
            b = a + 1;
            continue;
          }
          while (b < n && l[b] - l[a] < l[i] * 2) b++;
          b--;
          boolean flag = false;
          for (int j = a + 1; j <= b; j++) {
            if (j == i || j == i + 1) continue;
            if (l[a] < l[j]) {
              count1++;
              if (j >= i && j <= end) {
                count2++;
                j = end;
              } else if (a >= i && a <= end) {
                count2++;
                flag = true;
                break;
              }
            }
          }
          if (flag)
            a = end + 1;
          else
            a++;
          b = a + 1;
        }
        int len = end - i + 1;
        if (len >= 3) {
          count += len * (len - 1) / 2 * (count1 - count2);
          count += len * (len - 1) * (len - 2) / 6 * count2;
        } else {
          count += count1;
        }
        i = end + 1;
      } else {
        i++;
      }
    }

    return count;
  }
}
