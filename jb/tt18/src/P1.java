import java.util.Scanner;

public class P1 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int m = scan.nextInt();
    int c = scan.nextInt();
    boolean[][] a = new boolean[n][c];
    for (int i = 0; i < n; i++) {
      int num = scan.nextInt();
      for (int j = 0; j < num; j++) {
        int color = scan.nextInt() - 1;
        a[i][color] = true;
      }
    }
    int count = 0;
    for (int i = 0; i < c; i++) {
      int begin = 0;
      while (begin < n && !a[begin][i]) begin++;
      if (begin < n) {
        int last = begin;
        boolean find = false;
        for (int j = begin + 1; j < n; j++) {
          if (a[j][i]) {
            if (j - last < m) {
              count++;
              find = true;
              break;
            }
            last = j;
          }
        }
        if (!find && begin + n - last < m) count++;
      }
    }
    System.out.println(count);
  }
}
