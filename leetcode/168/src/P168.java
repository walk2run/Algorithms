// 168. Excel Sheet Column Title

class Solution {
  public String convertToTitle(int n) {
    StringBuilder sb = new StringBuilder();
    while (n > 0) {
      sb.append((char)('A' + (--n % 26)));
      n /= 26;
    }
    return sb.reverse().toString();
  }
}

public class P168 {
  public static void main(String[] args) {
    System.out.println(new Solution().convertToTitle(1));
  }
}
