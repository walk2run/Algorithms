import java.util.*;

/**
 * Created by yfy on 8/11/17.
 * 126. Word Ladder II
 */

class Solution {
  public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
    // to visit
    Set<String> unseenSet = new HashSet<>(wordList);
    if (!unseenSet.contains(endWord)) return paths;
    unseenSet.remove(beginWord);
    unseenSet.remove(endWord);
    // begin set
    Set<String> set1 = new HashSet<>();
    // end set
    Set<String> set2 = new HashSet<>();
    set1.add(beginWord);
    set2.add(endWord);
    boolean flip = false;
    while (!set1.isEmpty() && !set2.isEmpty()) {
      if (set1.size() > set2.size()) {
        Set<String> s = set1;
        set1 = set2;
        set2 = s;
        flip = !flip;
      }
      // find shortest path
      boolean find = false;
      Set<String> newSet = new HashSet<>();
      for (String word : set1) {
        char[] chars = word.toCharArray();
        for (int j = 0; j < chars.length; j++) {
          for (char k = 'a'; k <= 'z'; k++) {
            chars[j] = k;
            String newWord = new String(chars);
            if (set2.contains(newWord)) {
              find = true;
              addPath(word, newWord, flip);
            }
            if (unseenSet.contains(newWord)) {
              newSet.add(newWord);
              List<String> prev = prevs.get(newWord);
              if (prev == null) {
                prev = new ArrayList<>();
                prevs.put(newWord, prev);
              }
              prev.add(word);
            }
          }
          chars[j] = word.charAt(j);
        }
      }
      if (find)
        return paths;
      unseenSet.removeAll(newSet);
      set1 = newSet;
    }
    return paths;
  }

  // answer
  static List<List<String>> paths = new ArrayList<>();

  // word, previous words
  static Map<String, List<String>> prevs = new HashMap<>();

  static void addPath(String word1, String word2, boolean flip) {
    if (flip) {
      String s = word1;
      word1 = word2;
      word2 = s;
    }
    List<List<String>> lists = new ArrayList<>();
    List<String> list = new ArrayList<>();
    list.add(word1);
    dfs(lists, list, 0);

    list = new ArrayList<>();
    list.add(word2);
    dfs(lists, list, 1);
  }

  static void dfs(List<List<String>> lists, List<String> list, int type) {
    String word = list.get(list.size() - 1);
    List<String> prev = prevs.get(word);
    if (prev == null) {
      if (type == 0) {
        List<String> path = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--)
          path.add(list.get(i));
        lists.add(path);
      } else {
        for (List<String> pathHalf : lists) {
          List<String> path = new ArrayList<>();
          path.addAll(pathHalf);
          path.addAll(list);
          paths.add(path);
        }
      }
    } else {
      for (String prevWord : prev) {
        list.add(prevWord);
        dfs(lists, list, type);
        list.remove(list.size() - 1);
      }
    }
  }
}

public class P126 {
  public static void main(String[] args) {
    List<List<String>> paths = new Solution().findLadders("hot",
        "dog", Arrays.asList("hot","cog","dog","tot","hog","hop","pot","dot"));
    for (List<String> path : paths)
      System.out.println(Arrays.toString(path.toArray()));
  }
}
