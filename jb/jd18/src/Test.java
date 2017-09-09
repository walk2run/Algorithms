import java.util.Scanner;

public class Test {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    long count = 0;
    for (int a = 1; a <= n; a++) {
      System.out.println(count);
      for (int b = 1; b <= n; b++) {
        for (int c = 1; c <= n; c++) {
          if (a % c != 0 && c % a != 0) continue;
          for (int d = 1; d <= n; d++) {
            if (Math.pow(a, b) == Math.pow(c, d)) {
              System.out.println(a + " " + b + " " + c + " " + d);
              count++;
              if (count == 1000000007) count = 0;
            }
          }
        }
      }
    }
    System.out.println(count);
  }
}