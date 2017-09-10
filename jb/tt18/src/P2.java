import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P2 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++)
      a[i] = scan.nextInt();
    Map<Integer, int[]> map = new HashMap<>();
    int q = scan.nextInt();
    for (int i = 0; i < q; i++) {
      int l = scan.nextInt() - 1;
      int r = scan.nextInt() - 1;
      int k = scan.nextInt();
      int[] cnt = map.get(k);
      if (cnt == null) {
        cnt = new int[n];
        if (a[0] == k) cnt[0] = 1;
        for (int j = 1; j < n; j++) {
          cnt[j] = cnt[j - 1];
          if (a[j] == k) cnt[j]++;
        }
        map.put(k, cnt);
      }
      int left = 0;
      if (l > 0) left = cnt[l - 1];
      System.out.println(cnt[r] - left);

      /*int count = 0;
      for (int j = l; j <= r; j++)
        if (a[j] == k) count++;
      System.out.println(count);*/
    }
  }
}
