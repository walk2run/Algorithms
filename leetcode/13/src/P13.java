// 13. Roman to

class Solution {
  public int romanToInt(String s) {
    int[] a = new int[256];
    a['I'] = 1;
    a['V'] = 5;
    a['X'] = 10;
    a['L'] = 50;
    a['C'] = 100;
    a['D'] = 500;
    a['M'] = 1000;
    int sum = 0;
    for (int i = 0; i < s.length() - 1; i++) {
      if (a[s.charAt(i)] < a[s.charAt(i + 1)])
        sum -= a[s.charAt(i)];
      else
        sum += a[s.charAt(i)];
    }
    sum += a[s.charAt(s.length() - 1)];
    return sum;
  }
}

public class P13 {
}
