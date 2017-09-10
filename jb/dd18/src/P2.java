import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P2 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    List<Integer> l = new ArrayList<>();
    l.add(1);
    int a = 0, b = 0, c = 0;
    for (int i = 1; i < n; i++) {
      l.add(Math.min(l.get(a) * 2, Math.min(l.get(b) * 3, l.get(c) * 5)));
      int v = l.get(i);
      if (v == l.get(a) * 2) a++;
      if (v == l.get(b) * 3) b++;
      if (v == l.get(c) * 5) c++;
    }
    System.out.println(l.get(n - 1));
  }
}
