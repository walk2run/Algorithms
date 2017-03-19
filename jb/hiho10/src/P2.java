import java.util.Scanner;

/**
 * Created by yfy on 2017/3/19.
 */
public class P2 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    long[][] d = new long[n][6];
    d[0][0] = d[0][1] = d[0][2] = 1;
    for (int i = 1; i < n; i++) {
      d[i][0] = (d[i - 1][0] + d[i - 1][2] + d[i - 1][4]) % 1000000007;
      d[i][1] = (d[i - 1][1] + d[i - 1][3] + d[i - 1][5] + d[i][0]) % 1000000007;
      d[i][2] = d[i - 1][0];
      d[i][3] = d[i - 1][1];
      d[i][4] = d[i - 1][2];
      d[i][5] = d[i - 1][3];
    }
    long sum = 0;
    for (int i = 0; i < 6; i++)
      sum = (sum + d[n - 1][i]) % 1000000007;
    System.out.println(sum);
  }
}
