/*
ID: iamyfy1
PROG: milk2
LANG: JAVA
 */
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by yfy on 2016/10/31.
 */

class Pair {
  int a, b;
  public Pair(int a, int b) {
    this.a = a;
    this.b = b;
  }
}

public class milk2 {
  public static void main(String[] args) throws Exception {
    int n, i, max, max2, begin, end;
    Scanner scan = new Scanner(new BufferedInputStream(new FileInputStream("milk2.in")));
    n = scan.nextInt();
    List<Pair> list = new ArrayList<>();
    for (i = 0; i < n; i++)
      list.add(new Pair(scan.nextInt(), scan.nextInt()));

    list.sort((o1, o2) -> o1.a - o2.a);
    max = max2 = 0;
    begin = end = -1;
    for (Pair pair : list) {
      if (pair.a <= end) {
        end = Math.max(end, pair.b);
        max = Math.max(max, end - begin);
      } else {
        begin = pair.a;
        if (end >= 0)
          max2 = Math.max(max2, begin - end);
        end = pair.b;
        max = Math.max(max, end - begin);
      }
    }
    PrintWriter writer = new PrintWriter("milk2.out");
    writer.println(max + " " + max2);
    writer.close();
  }
}
