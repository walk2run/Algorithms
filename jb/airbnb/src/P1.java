import java.util.Arrays;

public class P1 {
  static void socialGraphs(int[] counts) {
    int n = counts.length;
    int[] next = new int[n];
    int[] last = new int[n + 1];
    Arrays.fill(last, -1);
    for (int i = 0; i < n; i++) {
      int count = counts[i];
      if (last[count] != -1)
        next[last[count]] = i;
      last[count] = i;
    }
    boolean[] use = new boolean[n];
    for (int i = 0; i < n; i++) {
      if (use[i]) continue;
      System.out.print(i);
      use[i] = true;
      int p = i;
      for (int j = 1; j < counts[i]; j++) {
        p = next[p];
        System.out.print(" " + p);
        use[p] = true;
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    socialGraphs(new int[]{3, 3, 3, 3, 3, 1, 3});
  }
}
