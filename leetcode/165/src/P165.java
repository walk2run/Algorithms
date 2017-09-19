// 165. Compare Version Numbers

class Solution {
  public int compareVersion(String version1, String version2) {
    String[] v1 = version1.split("\\.");
    String[] v2 = version2.split("\\.");
    int n1 = v1.length;
    int n2 = v2.length;
    for (int i = 0; i < Math.max(n1, n2); i++) {
      int a = i < n1 ? Integer.parseInt(v1[i]) : 0;
      int b = i < n2 ? Integer.parseInt(v2[i]) : 0;
      if (a > b) return 1;
      if (a < b) return -1;
    }
    return 0;
  }
}

public class P165 {
  public static void main(String[] args) {
    System.out.println(new Solution().compareVersion("1", "0"));
  }
}
