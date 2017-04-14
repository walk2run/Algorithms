import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by yfy on 2017/4/14.
 */
public class P1_2 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    Map<Integer, Integer> xmap = new HashMap<>();
    Map<Integer, Integer> ymap = new HashMap<>();
    Map<Integer, Integer> dmap = new HashMap<>();
    Map<Integer, Integer> emap = new HashMap<>();
    for (int i = 0; i < n; i++) {
      int x = scan.nextInt();
      int y = scan.nextInt();
      xmap.put(x, getOrDefault(xmap, x) + 1);
      ymap.put(y, getOrDefault(ymap, y) + 1);
      dmap.put(y - x, getOrDefault(dmap, y - x) + 1);
      emap.put(y + x, getOrDefault(emap, y + x) + 1);
    }
    long ans = count(xmap) + count(ymap) + count(dmap) + count(emap);
    System.out.println(ans);
  }

  private static int getOrDefault(Map<Integer, Integer> map, int key) {
    Integer v = map.get(key);
    if (v == null) return 0;
    return v;
  }

  private static long count(Map<Integer, Integer> map) {
    long sum = 0;
    for (int key : map.keySet()) {
      long n = map.get(key);
      sum += n * (n - 1) / 2;
    }
    return sum;
  }
}