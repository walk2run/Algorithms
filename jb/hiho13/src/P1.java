import java.util.Scanner;

/**
 * Created by yfy on 2017/4/9.
 */
public class P1 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    for (int i = 0; i < n; i++)
      System.out.println(trans(scan.next()));
  }

  private static String trans(String str) {
    String out = "";
    for (int i = 0; i < str.length(); i++) {
      char ch = str.charAt(i);
      if (ch == '_') {
        if (i + 1 < str.length())
          out += (char) (str.charAt((i++) + 1) + 'A' - 'a');
      } else if (Character.isUpperCase(ch))
        out += "_" + (char)(ch + 'a' - 'A');
      else
        out += ch;
    }
    return out;
  }
}
