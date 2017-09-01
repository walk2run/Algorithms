import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P2 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    int m = scan.nextInt();
    int[] a = new int[n];
    List<Integer> list = new ArrayList<>();
    int count = 0;
    for (int i = 0; i < n; i++) {
      a[i] = scan.nextInt();
      if (a[i] == 0) {
        count++;
        list.add(i);
      }
    }
    if (count < m) {
      System.out.println(-1);
      return;
    }
    int len = list.size();
    for (int i = 0; i < len; i++)
      list.add(list.get(i) + n);
    for (int i = 0; i < len; i++)
      list.add(list.get(i) + n + n);

    int[] left = new int[len * 2];
    left[0] = list.get(0);
    for (int i = 1; i < len * 2; i++)
      left[i] = left[i - 1] + list.get(i);

    int[] right = new int[len * 3];
    right[len * 3 - 1] = 3 * n - 1 - list.get(len * 3 - 1);
    for (int i = len * 3 - 2; i >= len; i--)
      right[i] = right[i + 1] + 3 * n - 1 - list.get(i);

    long min = Long.MAX_VALUE;
    for (int i = len - m + 1; i < len * 2; i++) {
      int j = i + m - 1;
      int mid = (i + j) / 2;
      long cl = mid - i + 1;
      long cr = j - mid + 1;
      long v = cl * list.get(mid) - (left[mid] - i > 0 ? left[i - 1] : 0) +
          cr * (n * 3 - 1 - list.get(mid)) - (right[mid] - j + 1 < len * 3 ? right[j + 1] : 0);
      min = Math.min(v, min);
    }

    System.out.println(min);
  }
}
