import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by yfy on 2017/4/13.
 * 好难
 * http://blog.csdn.net/buptzhengchaojie/article/details/69831275
 */
public class P4 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String str = scan.next();
    Pair p1 = dp(str);
    StringBuilder sb = new StringBuilder(str).reverse();
    for (int i = 0; i < sb.length(); i++) {
      if (sb.charAt(i) == '(')
        sb.setCharAt(i, ')');
      else
        sb.setCharAt(i, '(');
    }
    Pair p2 = dp(sb.toString());
    System.out.println(p1.need + p2.need + " " + (long)(p1.method) * p2.method % 1000000007);
  }

  private static Pair dp(String str) {
    int left = 0, right = 0, diff = 0;
    int[] mins = new int[str.length()];
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == '(') left++;
      else {
        right++;
        diff = Math.max(right - left, diff);
        mins[right - 1] = diff;
      }
    }
    int[] d = new int[diff + 1];
    for (int i = 0; i < right; i++) {
      if (i == 0) {
        Arrays.fill(d, mins[i], diff + 1, 1);
        continue;
      }
      for (int j = mins[i]; j <= diff; j++) {
        if (j == mins[i]) {
          int sum = 0;
          for (int k = 0; k <= j; k++) {
            sum = (sum + d[k]) % 1000000007;
            d[k] = 0;
          }
          d[j] = sum;
        } else {
          d[j] = (d[j - 1] + d[j]) % 1000000007;
        }
      }
    }
    if (diff == 0) d[diff] = 1;
    return new Pair(diff, d[diff]);
  }

  private static class Pair {
    int need, method;
    Pair(int need, int method) {
      this.need = need;
      this.method = method;
    }
  }
}
