import java.util.Scanner;

/**
 * Created by yfy on 2017/2/13.
 */
public class P2 {
  private static Scanner scan = new Scanner(System.in);

  public static void main(String[] args) {
    int t = scan.nextInt();
    for (int i = 0; i < t; i++)
      deal();
  }

  private static void deal() {
    int n = scan.nextInt();
    int a[] = new int[n];
    int i = 0;
    int num = 0;
    while (num < n) {
      while (a[i] > 0) i = (i + 1) % n;
      i = (i + 1) % n;
      while (a[i] > 0) i = (i + 1) % n;
      a[i] = ++num;
    }
    System.out.print(a[0]);
    for (i = 1; i < n; i++)
      System.out.print(" " + a[i]);
    System.out.println();
  }
}
