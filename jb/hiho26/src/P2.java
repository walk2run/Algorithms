import java.util.*;

class Module implements Comparable<Module> {
  int v, p;
  boolean jar;

  Module(int v, int p, boolean jar) {
    this.v = v;
    this.p = p;
    this.jar = jar;
  }

  @Override
  public int compareTo(Module o) {
    return o.v - v;
  }
}

public class P2 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    for (int i = 0; i < t; i++)
      solve(scan);
  }

  static void solve(Scanner scan) {
    int n = scan.nextInt();
    int m = scan.nextInt();
    int k = scan.nextInt();
    Module[] mods = new Module[n];
    List<Module>[] jl = new List[m];
    List<Module>[] njl = new List[m];
    for (int i = 0; i < m; i++) {
      jl[i] = new ArrayList<>();
      njl[i] = new ArrayList<>();
    }
    for (int i = 0; i < n; i++) {
      Module mod = new Module(scan.nextInt(), scan.nextInt() - 1, scan.nextInt() == 1);
      if (mod.jar) jl[mod.p].add(mod);
      else njl[mod.p].add(mod);
    }
    for (int i = 0; i < m; i++) {
      Collections.sort(jl[i]);
      Collections.sort(njl[i]);
    }
    int[] c = new int[m];
    for (int i = 0; i < m; i++)
      c[i] = scan.nextInt();

    int[][] d = new int[m][k + 1];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j <= k; j++) {
        int jsum = 0, njsum = 0;
        for (int l = 0; l < Math.min(njl[i].size(), c[i]); l++)
          njsum += njl[i].get(l).v;
        for (int a = 0; a <= Math.min(jl[i].size(), j); a++) {
          int val = jsum + njsum;
          if (i > 0) val += d[i - 1][j - a];
          if (val > d[i][j]) d[i][j] = val;
          if (a < jl[i].size()) jsum += jl[i].get(a).v;
          if (c[i] - a - 1 < njl[i].size() && c[i] - a - 1 >= 0)
            njsum -= njl[i].get(c[i] - a - 1).v;
        }
      }
    }
    System.out.println(d[m - 1][k]);
  }
}
