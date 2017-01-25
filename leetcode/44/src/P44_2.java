/**
 * Created by yfy on 10/26/16.
 * Wildcard Matching
 */

class Solution2 {
  public boolean isMatch(String s, String p) {
    int i, j, slen, plen, lasti, star;
    lasti = star = -1;
    slen = s.length(); // len
    plen = p.length();
    i = j = 0; // pointer
    while (i < slen) {
      if (j < plen && p.charAt(j) == '*') {
        while (j + 1 < plen && p.charAt(j + 1) == '*') j++;
        lasti = i;
        star = j++;
      } else if (j < plen &&
          (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
        i++;
        j++;
      } else if (star > -1) {
        i = ++lasti;
        j = star + 1;
      } else {
        return false;
      }
    }
    while (j < plen && p.charAt(j) == '*') j++;
    return j == p.length();
  }
}

public class P44_2 {
}
