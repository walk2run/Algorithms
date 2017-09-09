import java.util.*;

public class P3 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String s = scan.next();
    int n = s.length();
    int[] a = new int[n];
    int c = 0;
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == '(') a[i] = ++c;
      else a[i] = --c;
    }
    int max = 0;
    Map<Integer, Integer> map = new HashMap<>();
    Set<String> set = new HashSet<>();
    for (int i = 0; i < n; i++) {
      if (s.charAt(i) == '(') {
        for (int j = 0; j < n; j++) {
          if (s.charAt(j) == ')' && (j < i || a[i] > 1)) {
            StringBuilder sb = new StringBuilder(s);
            sb.setCharAt(i, ')');
            sb.setCharAt(j, '(');
            String str = sb.toString();
            if (!valid(str)) continue;
            if (set.contains(str)) continue;
            set.add(str);
            int len = lcs(s, str);
            if (len > max) max = len;
            Integer v = map.get(len);
            if (v == null) v = 0;
            map.put(len, v + 1);
          }
        }
      }
    }
    System.out.println(map.get(max));
  }

  static boolean valid(String s) {
    int count = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(') count++;
      else count--;
      if (count < 0) return false;
    }
    return true;
  }

  static int lcs(String a, String b){
    int m = a.length();
    int n = b.length();
    int[][] dp = new int[m+1][n+1];

    for(int i=0; i<=m; i++){
      for(int j=0; j<=n; j++){
        if(i==0 || j==0){
          dp[i][j]=0;
        }else if(a.charAt(i-1)==b.charAt(j-1)){
          dp[i][j] = 1 + dp[i-1][j-1];
        }else{
          dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
        }
      }
    }
    //System.out.println(a + " " + b + " " + dp[m][n]);
    return dp[m][n];
  }
}
