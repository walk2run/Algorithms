import java.util.*;

/**
 * Created by yfy on 8/10/17.
 * 127. Word Ladder
 */

class Solution1 {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> set = new HashSet<>(wordList);
    Queue<String> queue = new LinkedList<>();
    queue.offer(beginWord);
    int size = 1;
    int step = 0;
    while (size > 0) {
      step++;
      for (int i = 0; i < size; i++) {
        String word = queue.poll();
        char[] chars = word.toCharArray();
        for (int j = 0; j < chars.length; j++) {
          for (char k = 'a'; k <= 'z'; k++) {
            chars[j] = k;
            String newWord = new String(chars);
            if (set.contains(newWord)) {
              if (endWord.equals(newWord)) return step + 1;
              queue.offer(newWord);
              set.remove(newWord);
            }
          }
          chars[j] = word.charAt(j);
        }
      }
      size = queue.size();
    }
    return 0;
  }
}

class Solution3 {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> set = new HashSet<>(wordList);
    if (!set.contains(endWord)) return 0;
    set.remove(endWord);
    Queue<String> queue1 = new LinkedList<>();
    Queue<String> queue2 = new LinkedList<>();
    queue1.offer(beginWord);
    queue2.offer(endWord);
    int size1 = 1;
    int size2 = 1;
    int step = 0;
    while (size1 > 0 && size2 > 0) {
      step++;
      if (size1 > size2) {
        Queue<String> q = queue1;
        queue1 = queue2;
        queue2 = q;
        int s = size1;
        size1 = size2;
        size2 = s;
      }
      for (int i = 0; i < size1; i++) {
        String word = queue1.poll();
        char[] chars = word.toCharArray();
        for (int j = 0; j < chars.length; j++) {
          for (char k = 'a'; k <= 'z'; k++) {
            chars[j] = k;
            String newWord = new String(chars);
            if (queue2.contains(newWord)) return step + 1;
            if (set.contains(newWord)) {
              queue1.offer(newWord);
              set.remove(newWord);
            }
          }
          chars[j] = word.charAt(j);
        }
      }
      size1 = queue1.size();
    }
    return 0;
  }
}

class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> set = new HashSet<>(wordList);
    if (!set.contains(endWord)) return 0;
    set.remove(beginWord);
    set.remove(endWord);
    Set<String> set1 = new HashSet<>();
    Set<String> set2 = new HashSet<>();
    set1.add(beginWord);
    set2.add(endWord);
    int step = 0;
    while (!set1.isEmpty() && !set2.isEmpty()) {
      step++;
      if (set1.size() > set2.size()) {
        Set<String> s = set1;
        set1 = set2;
        set2 = s;
      }
      Set<String> newSet = new HashSet<>();
      for (String word : set1) {
        char[] chars = word.toCharArray();
        for (int j = 0; j < chars.length; j++) {
          for (char k = 'a'; k <= 'z'; k++) {
            chars[j] = k;
            String newWord = new String(chars);
            if (set2.contains(newWord)) return step + 1;
            if (set.contains(newWord)) {
              newSet.add(newWord);
              set.remove(newWord);
            }
          }
          chars[j] = word.charAt(j);
        }
      }
      set1 = newSet;
    }
    return 0;
  }
}

class Solution2 {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> reachedSet = new HashSet<>();
    reachedSet.add(beginWord);
    Set<String> set = new HashSet<>(wordList);
    if (!set.contains(endWord)) return 0;
    set.remove(endWord);
    Queue<String> queue = new LinkedList<>();
    queue.offer(beginWord);
    int size = 1;

    Set<String> reachedSet2 = new HashSet<>();
    reachedSet2.add(endWord);
    Queue<String> queue2 = new LinkedList<>();
    queue2.offer(endWord);
    int size2 = 1;

    int step = 0;
    while (size > 0 || size2 > 0) {
      if (size > 0) step++;
      for (int i = 0; i < size; i++) {
        String word = queue.poll();
        char[] chars = word.toCharArray();
        for (int j = 0; j < chars.length; j++) {
          for (char k = 'a'; k <= 'z'; k++) {
            chars[j] = k;
            String newWord = new String(chars);
            if (reachedSet2.contains(newWord))
              return step + 1;
            if (set.contains(newWord)) {
              reachedSet.add(newWord);
              queue.offer(newWord);
              set.remove(newWord);
            }
          }
          chars[j] = word.charAt(j);
        }
      }
      size = queue.size();

      if (size2 > 0) step++;
      for (int i = 0; i < size2; i++) {
        String word = queue2.poll();
        char[] chars = word.toCharArray();
        for (int j = 0; j < chars.length; j++) {
          for (char k = 'a'; k <= 'z'; k++) {
            chars[j] = k;
            String newWord = new String(chars);
            if (reachedSet.contains(newWord)) return step + 1;
            if (set.contains(newWord)) {
              reachedSet2.add(newWord);
              queue2.offer(newWord);
              set.remove(newWord);
            }
          }
          chars[j] = word.charAt(j);
        }
      }
      size2 = queue2.size();
    }
    return 0;
  }
}

public class P127 {
  public static void main(String[] args) {
    System.out.println(new Solution().ladderLength("hit", "cog",
        Arrays.asList("hot","dot","dog","lot","log","cog")));
  }
}
