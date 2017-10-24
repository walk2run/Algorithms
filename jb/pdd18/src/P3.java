import java.util.Arrays;
import java.util.Scanner;

class Bao implements Comparable<Bao> {
  int del, dif, id;

  public Bao(int del, int dif, int id) {
    this.del = del;
    this.dif = dif;
    this.id = id;
  }

  @Override
  public int compareTo(Bao o) {
    if (o.del == del) return o.dif - dif;
    return o.del - del;
  }
}

public class P3 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int m = scan.nextInt();
    Bao[] baos = new Bao[n];
    for (int i = 0; i < n; i++)
      baos[i] = new Bao(scan.nextInt(), scan.nextInt(), i);
    while (true) {
      Arrays.sort(baos);
      int count = 0;
      for (Bao bao : baos) {
        if (bao.del > 0) {
          bao.del = -1;
          if (++count == 2) break;
        }
      }
      count = 0;
      for (Bao bao : baos) {
        if (bao.del > 0) {
          bao.del -= bao.dif;
          if (bao.del < 0) bao.del = 0;
        }
        if (bao.del > 0) count++;
      }
      if (count < m) break;
    }
    int[] ans = new int[n];
    for (Bao bao : baos)
      ans[bao.id] = bao.del;
    for (int v : ans)
      System.out.println(v);
  }
}
