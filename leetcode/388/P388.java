public class Solution {
  public int lengthLongestPath(String input) {
    List<Integer> list = new ArrayList<>();
    int wordLen = 0, len = 0, max = 0, tabCount = 0;
    boolean file = false;
    for (int i = 0; i < input.length(); i++) {
      char ch = input.charAt(i);
      if (ch == '\n') {
        if (file == true)
          max = Math.max(max, len);
        if (tabCount < list.size())
          list.set(tabCount, wordLen);
        else
          list.add(wordLen);
        tabCount = wordLen = len = 0;
        file = false;
      } else if (ch == '\t') {
        len += list.get(tabCount) + 1;
        tabCount++;
      } else {
        wordLen++;
        len++;
        if (ch == '.') file = true;
      }
    }
    if (file == true)
      max = Math.max(max, len);
    return max;
  }
}