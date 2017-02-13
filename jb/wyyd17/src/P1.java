import java.util.Scanner;

/**
 * Created by yfy on 2017/2/13.
 */
public class P1 {
  private static Scanner scan = new Scanner(System.in);
  public static void main(String[] args) {
    int t = scan.nextInt();
    for (int i = 0; i < t; i++)
      deal();
  }

  private static void deal() {
    int n = scan.nextInt();
    int k = scan.nextInt();
    int[] a = new int[2 * n];
    int[] b = new int[2 * n];
    int[] c;
    for (int i = 0; i < 2 * n; i++)
      a[i] = scan.nextInt();
    for (int i = 0; i < k; i++) {
      shuffle(a, b, n);
      c = a;
      a = b;
      b = c;
    }
    System.out.print(a[0]);
    for (int i = 1; i < 2 * n; i++)
      System.out.print(" " + a[i]);
    System.out.println();
  }

  private static void shuffle(int[] a, int[] b, int n) {
    for (int i = n - 1; i >= 0; i--) {
      b[i * 2 + 1] = a[i + n];
      b[i * 2] = a[i];
    }
  }
}