import java.util.Scanner;

/**
 * Created by yfy on 2017/3/19.
 */
public class P1 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    for (int i = 0; i < t; i++)
      solve(scan.next());
  }

  private static void solve(String s) {
    int absent = 0, late = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == 'L')
        late++;
      else
        late = 0;
      if (late == 3) break;
      if (s.charAt(i) == 'A') absent++;
      if (absent > 1) break;
    }
    if (late == 3 || absent > 1)
      System.out.println("NO");
    else
      System.out.println("YES");
  }
}
