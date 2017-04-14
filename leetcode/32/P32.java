// stack
public class Solution {
  public int longestValidParentheses(String s) {
    int max = 0;
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '(')
        list.add(i);
      else {
        if (!list.isEmpty() && s.charAt(list.get(list.size() - 1)) == '(') {
          list.remove(list.size() - 1);
          int last = list.isEmpty() ? -1 : list.get(list.size() - 1);
          max = Math.max(max, i - last);
        } else {
          list.add(i);
        }
      }
    }
    return max;
  }
}