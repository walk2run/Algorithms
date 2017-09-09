import java.util.Scanner;

public class P1 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    StringBuilder sb = new StringBuilder();
    while (n > 0) {
      if (n % 2 == 0) {
        sb.append('2');
        n = (n - 2) / 2;
      } else {
        sb.append('1');
        n = (n - 1) / 2;
      }
    }
    System.out.println(sb.reverse());
  }
}
