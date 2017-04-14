import java.util.Scanner;

/**
 * Created by yfy on 2017/4/14.
 */
public class P3 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    long[] a = new long[n];
    long[] b = new long[n];
    long sum = 0;
    for (int i = 0; i < n; i++) {
      sum += a[i] = scan.nextLong();
      sum += b[i] = scan.nextLong();
    }
    long avg = sum / (n * 2);
    long move = 0;
    for (int i = 0; i < n; i++) {
       if (a[i] > avg && b[i] < avg) {
        long diff = Math.min(a[i] - avg, avg - b[i]);
        move += diff;
        a[i] -= diff;
        b[i] += diff;
      } else if (a[i] < avg && b[i] > avg) {
        long diff = Math.min(avg - a[i], b[i] - avg);
        move += diff;
        a[i] += diff;
        b[i] -= diff;
      }
      if (i == n - 1) break;
      if (a[i] < avg) {
        move += avg - a[i];
        a[i + 1] -= avg - a[i];
      } else {
        move += a[i] - avg;
        a[i + 1] += a[i] - avg;
      }
      if (b[i] < avg) {
        move += avg - b[i];
        b[i + 1] -= avg - b[i];
      } else {
        move += b[i] - avg;
        b[i + 1] += b[i] - avg;
      }
    }
    System.out.println(move);
  }
}
