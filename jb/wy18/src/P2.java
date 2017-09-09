import java.util.Scanner;

public class P2 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    for (int i = 0; i < t; i++)
      solve(scan);
  }

  static void solve(Scanner scan) {
    int n = Integer.parseInt(scan.next());
    int c0 = 0, c2 = 0;
    for (int i = 0; i < n; i++) {
      int v = Integer.parseInt(scan.next());
      if (v % 2 == 1) c0++;
      else if (v % 4 == 0) c2++;
    }
    System.out.println(c2 >= c0 ? "Yes" : "No");
  }
}
