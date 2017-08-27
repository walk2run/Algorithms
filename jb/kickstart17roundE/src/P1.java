import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by yfy on 8/27/17.
 */
public class P1 {
  public static void main(String[] args) throws Exception {
    Scanner scan = new Scanner(new File("A-large.in"));
    int t = scan.nextInt();
    PrintWriter pw = new PrintWriter("A-large.out");
    for (int i = 1; i <= t; i++)
      pw.printf("Case #%d: %d\n", i, solve(scan));
    pw.close();
  }

  static int solve(Scanner scan) {
    String s = scan.next();
    int n = s.length();
    int[] d = new int[n];
    d[0] = 1;
    for (int i = 1; i < n; i++) {
      d[i] = d[i - 1] + 1;
      for (int j = i / 2; j < i - 1; j++) {
        String left = s.substring(0, j + 1);
        String right = s.substring(j + 1, i + 1);
        int pos = contain(left, right);
        if (pos >= 0)
          d[i] = Math.min(d[i], d[j] + 2);
        else
          continue;

        int len = i - j;
        int count = 3;
        for (int k = j - len; k >= pos + len - 1 && equal(s, j + 1, k + 1, len); k -= len)
          d[i] = Math.min(d[i], d[k] + (count++));
      }
    }
    return d[n - 1];
  }

  static boolean equal(String s, int a, int b, int len) {
    for (int i = 0; i < len; i++)
      if (s.charAt(a + i) != s.charAt(b + i))
        return false;
    return true;
  }

  static int contain(String haystack, String needle) {
    int n, m, i, q;

    n = haystack.length();
    m = needle.length();

    int[] next = new int[m];
    q = next[0] = 0;
    for (i = 1; i < m; i++) {
      while (q > 0 && needle.charAt(q) != needle.charAt(i))
        q = next[q - 1];
      if (needle.charAt(q) == needle.charAt(i))
        q++;
      next[i] = q;
    }

    q = 0;	// next[]
    for (i = 0; i < n; i++) {
      while (q > 0 && needle.charAt(q) != haystack.charAt(i))
        q = next[q - 1];
      if (needle.charAt(q) == haystack.charAt(i))
        q++;
      if (q == m)
        return i - m + 1;
    }

    return -1;
  }
}
