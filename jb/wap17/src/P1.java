import java.util.Scanner;

public class P1 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt(), ans = 0;
    int[] a = new int[n];
    for (int i = 0; i < n; i++)
      a[i] = scan.nextInt();
    for (int i = 0; i < n - 1; i++) {
      int max = a[i], max2 = -1;
      for (int j = i + 1; j < n; j++) {
        if (a[j] > max) {
          max2 = max;
          max = a[j];
        } else if (a[j] < max && a[j] > max2) {
          max2 = a[j];
        }
        if (max2 > 0)
          ans = Math.max(ans, max ^ max2);
      }
    }
    System.out.println(ans);
  }
}
