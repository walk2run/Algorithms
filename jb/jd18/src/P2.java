import java.util.Scanner;

public class P2 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    long count = n * n % 1000000007;
    for (int a = 2; a <= n; a++) {
      System.out.println(count);
      count += n;
      for (int times = 2; ; times++) {
        int root = (int) Math.pow(a, 1.0/times);
        if (root < 2) break;
        int pro = (int)Math.pow(root, times);
        if (a == pro)
          count += n / times;
      }
      for (int times = 2; ; times++) {
        int pro = (int)Math.pow(a, times);
        if (pro > n) break;
        count += n / times;
      }
      count %= 1000000007;
    }
    System.out.println(count);
  }
}
