public class Finder {
  public int findKth(int[] a, int n, int K) {
    return f(a, 0, n - 1, K);
  }
  
  private int f(int[] a, int l, int r, int k) {
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
    if (j - l + 1 == k) return a[j];
    if (j - l + 1 > k) return f(a, l, j, k);
    return f(a, j + 1, r, k - (j - l + 1));
  }

  public static void main(String[] args) {
    System.out.println(new Finder().findKth(new int[]{1, 3, 5, 2, 2}, 5, 3));
  }
}