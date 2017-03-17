import java.util.Scanner;

/**
 * Created by yfy on 2017/3/17.
 */
public class P2 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int[] a = new int[5];
    while (scan.hasNext()) {
      String str = scan.next();
      for (int i = 0; i < 5; i++)
        if (str.charAt(i) == '1') a[i]++;
    }
    int min = Integer.MAX_VALUE;
    for (int v : a)
      if (v < min) min = v;
    System.out.println(min);
  }
}
