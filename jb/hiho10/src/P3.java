import java.util.*;

/**
 * Created by yfy on 2017/3/19.
 */
public class P3 {
  public static void main(String[] args) {
    scan = new Scanner(System.in);
    int t = scan.nextInt();
    for (int i = 0; i < t; i++)
      solve();
  }

  private static Scanner scan;

  private static void solve() {
    int n, k;
    n = scan.nextInt();
    k = scan.nextInt();
    int[] a = new int[n];
    for (int i = 0; i < n; i++)
      a[i] = scan.nextInt();
    //List<Integer> list = new ArrayList<>();
    int size;
    if (n % 2 == 0)
      size = n / 2 * (n + 1);
    else
      size = (n + 1) / 2 * n;
    int[] list = new int[size];
    int listC = 0;
    for (int i = 0; i < n; i++) {
      Map<Integer, Integer> map = new HashMap<>();
      int count = 0;
      for (int j = i; j < n; j++) {
        Integer value = map.get(a[j]);
        if (value == null)
          map.put(a[j], 1);
        else {
          map.put(a[j], value + 1);
          count = count - (value - 1) * value / 2 + (value + 1) * value / 2;
        }
        list[listC] = count;
        listC++;
      }
    }
    //System.out.println(Arrays.toString(list));
    int ans = sort(list, 0, size - 1, k);
    //Collections.sort(list);
    System.out.println(ans);
  }

  private static int sort(int[] a, int l, int r, int k) {
    if (l == r && k == 1) return a[l];
    int i, j, x, t;
    i = l;
    j = r;
    x = a[(l + r) / 2];
    while (i <= j) {
      while (a[i] < x) i++;
      while (a[j] > x) j--;
      if (i <= j) {
        t = a[i];
        a[i] = a[j];
        a[j] = t;
        i++;
        j--;
      }
    }
    if (l <= j && k <= j - l + 1) return sort(a, l, j, k);
    if (i <= r && k > i - l) return sort(a, i, r, k - (i - l));
    return a[j + 1];
  }
}

class P3_2 {
  private static Scanner scan;

  public static void main(String[] args) {
    scan = new Scanner(System.in);
    int t = scan.nextInt();
    for (int i = 0; i < t; i++)
      solve();
  }

  private static void solve() {
    int n, k;
    n = scan.nextInt();
    k = scan.nextInt();
    int[] a = new int[n];
    Map<Integer, Integer> map = new HashMap<>();
    int count = 0;
    for (int i = 0; i < n; i++) {
      int x = scan.nextInt();
      Integer value = map.get(x);
      if (value == null) {
        a[i] = count;
        map.put(x, count);
        count++;
      } else {
        a[i] = value;
      }
    }
    //for (int x : a) System.out.println(x);
    long l = 0, r = n * (long)(n - 1) / 2;
    while (l < r) {
      long mid = (l + r) / 2;
    }
  }
}