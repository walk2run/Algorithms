import java.util.Scanner;

/**
 * Created by yfy on 2017/3/26.
 */
public class P1 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String str = scan.next();
    int n = str.length();
    int i;
    for (i = 3; i <= n; i++)
      if (find(str, i)) break;
    if (i == n + 1)
      System.out.println(-1);
    else
      System.out.println(i);
  }

  private static boolean find(String str, int len) {
    int hc = 0, ic = 0, oc = 0;
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == 'h')
        hc++;
      else if (str.charAt(i) == 'i')
        ic++;
      else if (str.charAt(i) == 'o')
        oc++;
      if (i - len >= 0) {
        if (str.charAt(i - len) == 'h')
          hc--;
        else if (str.charAt(i - len) == 'i')
          ic--;
        else if (str.charAt(i - len) == 'o')
          oc--;
      }
      if (hc == 2 && ic == 1 && oc == 1)
        return true;
    }
    return false;
  }
}

class P1_2 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String str = scan.next();
    int n = str.length();
    int j = 0, hc = 0, ic = 0, oc = 0, min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      while (j < n && (hc < 2 || ic < 1 || oc < 1)) {
        if (str.charAt(j) == 'h')
          hc++;
        else if (str.charAt(j) == 'i')
          ic++;
        else if (str.charAt(j) == 'o')
          oc++;
        j++;
      }
      if (hc == 2 && ic == 1 && oc == 1)
        min = Math.min(min, j - i);
      if (str.charAt(i) == 'h')
        hc--;
      else if (str.charAt(i) == 'i')
        ic--;
      else if (str.charAt(i) == 'o')
        oc--;
    }
    if (min > n) min = -1;
    System.out.println(min);
  }
}
