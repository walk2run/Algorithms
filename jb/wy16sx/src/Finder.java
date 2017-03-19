public class Finder {
  public int findKth(int[] a, int n, int K) {
    return f(a, 0, n - 1, K);
  }
  
  private int f(int[] a, int l, int r, int k) {
    if (l == r && k == 1) return a[l];
    int v = a[(l + r) / 2];
    int i = l;
    int j = r;
    while (i <= j) {
      while (a[i] > v) i++;
      while (a[j] < v) j--;
      if (i <= j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
        i++;
        j--;
      }
    }
    if (l <= j && k <= j - l + 1) return f(a, l, j, k);
    if (i <= r && k > i - l) return f(a, i, r, k - (i - l));
    return a[j + 1];
  }

  public static void main(String[] args) {
    System.out.println(new Finder().findKth(new int[]{1, 3, 5, 2, 2}, 5, 3));
  }
}