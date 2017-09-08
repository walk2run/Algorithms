import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P1 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String str = scan.next();
    map = new HashMap<>();
    System.out.println(f(str));
  }

  static Map<String, Long> map;

  static long f(String str) {
    if (str.isEmpty()) return 1;
    Long v = map.get(str);
    if (v != null) return v;
    int count = 1, end = 0;
    while (true) {
      end++;
      if (str.charAt(end) == '(')
        count++;
      else
        count--;
      if (count == 0) break;
    }
    long sum = 0;
    for (int i = 1; i <= end; i++) {
      if (str.charAt(i) == ')') {
        sum += f(str.substring(1, i) + str.substring(i + 1));
      }
    }
    map.put(str, sum);
    return sum;
  }
}
