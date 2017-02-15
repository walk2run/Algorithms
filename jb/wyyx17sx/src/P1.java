import java.util.Scanner;

/**
 * Created by yfy on 2/15/2017.
 */
public class P1 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String st = scan.next();
    char last = ' ';
    int count = 0;
    for (int i = 0; i < st.length(); i++) {
      if (st.charAt(i) == last) {
        count++;
      } else {
        if (last != ' ') {
          System.out.print(count);
          System.out.print(last);
        }
        count = 1;
        last = st.charAt(i);
      }
    }
    System.out.print(count);
    System.out.print(last);
  }
}
