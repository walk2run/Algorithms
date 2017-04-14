import java.util.Scanner;

/**
 * Created by yfy on 2017/4/14.
 */
public class P1 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int[] x = new int[n];
    int[] y = new int[n];
    for (int i = 0; i < n; i++) {
      x[i] = scan.nextInt();
      y[i] = scan.nextInt();
    }
    long count = 0;
    for (int i = 0; i < n - 1; i++)
      for (int j = i + 1; j < n; j++)
        if (x[i] == x[j] || y[i] == y[j] || Math.abs(x[i] - x[j]) == Math.abs(y[i] - y[j]))
          count++;
    System.out.println(count);
  }
}