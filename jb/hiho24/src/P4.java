import java.util.Scanner;

public class P4 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++)
      a[i] = scan.nextInt();
    int[] d = new int[n];
    /*for (int i = n - 1; i >= 0; i--) {
      if (i + a[i] < n)
        d[i] = d[i + a[i]] + 1;
      else
        d[i] = 1;
    }*/
    int q = scan.nextInt();
    for (int i = 0; i < q; i++) {
      int x = scan.nextInt();
      if (x == 1) {
        int y = scan.nextInt() - 1;
        int count = 0;
        while (y < n) {
          count++;
          y += a[y];
        }
        System.out.println(count);
      } else {
        int u = scan.nextInt() - 1;
        int v = scan.nextInt();
        a[u] = v;
      }
    }
  }
}
