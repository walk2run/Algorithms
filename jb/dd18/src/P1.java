import java.util.Scanner;

public class P1 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++)
      a[i] = scan.nextInt();
    int[] d = new int[n];
    //if (a[0] == 0) d[0] = 1; else d[0] = 0;
    for (int i = 0; i < n; i++) {
      int v = 0;
      for (int j = i; j >= 0; j--) {
        v ^= a[j];
        int k = j == 0 ? 0 : d[j - 1];
        if (v == 0) k++;
        if (k > d[i]) d[i] = k;
      }
      //System.out.println(d[i]);
    }
    System.out.println(d[n - 1]);
  }
}
