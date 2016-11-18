/*
ID: iamyfy1
PROG: milk
LANG: JAVA
 */
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by yfy on 16-11-18.
 */
public class milk {
  public static void main(String[] args) throws Exception {
    int n, m, i, amount, cost;
    Scanner scan = new Scanner(new BufferedInputStream(new FileInputStream("milk.in")));
    n = scan.nextInt();
    m = scan.nextInt();
    List<Pair> list = new ArrayList<>();
    for (i = 0; i < m; i++)
      list.add(new Pair(scan.nextInt(), scan.nextInt()));
    list.sort((o1, o2) -> o1.p - o2.p);
    amount = cost = 0;
    for (Pair pair : list) {
      if (amount + pair.a >= n) {
        cost += (n - amount) * pair.p;
        break;
      } else {
        cost += pair.p * pair.a;
        amount += pair.a;
      }
    }
    PrintWriter pw = new PrintWriter("milk.out");
    pw.println(cost);
    pw.close();
  }

  private static class Pair {
    int p, a;
    Pair(int p, int a) {
      this.p = p;
      this.a = a;
    }
  }

}
