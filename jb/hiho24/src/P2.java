import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P2 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int m = scan.nextInt();
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (scan.nextInt() == 0)
        list.add(i);
    }
    if (list.size() < m) {
      System.out.println(-1);
      return;
    }
    int len = list.size();
    for (int i = 0; i < len; i++)
      list.add(list.get(i) + n);
    for (int i = 0; i < len; i++)
      list.add(list.get(i) + n + n);

    long[] left = new long[len * 3];
    left[0] = list.get(0);
    for (int i = 1; i < len * 3; i++)
      left[i] = left[i - 1] + list.get(i);

    long[] right = new long[len * 3];
    right[len * 3 - 1] = 3 * n - 1 - list.get(len * 3 - 1);
    for (int i = len * 3 - 2; i >= 0; i--)
      right[i] = right[i + 1] + 3 * n - 1 - list.get(i);

    long min = Long.MAX_VALUE;
    for (int i = len - m + 1; i < len * 2; i++) {
      int j = i + m - 1;
      int mid = (i + j) / 2;
      long cl = mid - i + 1;
      long cr = j - mid + 1;
      long v = cl * list.get(mid) - (left[mid] - (i > 0 ? left[i - 1] : 0)) +
          cr * (n * 3 - 1 - list.get(mid)) - (right[mid] - (j + 1 < len * 3 ? right[j + 1] : 0));
      min = Math.min(v, min);
    }

    System.out.println(min);
  }
}
