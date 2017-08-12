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
  List<List<String>> paths = new ArrayList<>();

  // word, previous words
  Map<String, List<String>> prevs = new HashMap<>();

  void addPath2(String word1, String word2, boolean flip) {
    if (flip) {
      String s = word1;
      word1 = word2;
      word2 = s;
    }
    List<List<String>> lists = new ArrayList<>();
    f(word1, lists, 0);
    f(word2, lists, 1);
  }

  void f(String word, List<List<String>> lists, int type) {
    List<String> list = new ArrayList<>();
    list.add(word);
    List<Integer> stack = new ArrayList<>();
    stack.add(0);
    while (!list.isEmpty()) {
      String w = list.get(list.size() - 1);
      List<String> prev = prevs.get(w);
      if (prev == null) {
        if (type == 0) {
          List<String> path = new ArrayList<>();
          for (int i = list.size() - 1; i >= 0; i--)
            path.add(list.get(i));
          lists.add(path);
        } else {
          for (List<String> pathBegin : lists) {
            List<String> path = new ArrayList<>();
            path.addAll(pathBegin);
            path.addAll(list);
            paths.add(path);
          }
        }
        list.remove(list.size() - 1);
        stack.remove(stack.size() - 1);
      } else {
        int i = stack.get(stack.size() - 1);
        if (i < prev.size()) {
          String wp = prev.get(i);
          list.add(wp);
          i++;
          stack.set(stack.size() - 1, i);
          stack.add(0);
        } else {
          list.remove(list.size() - 1);
          stack.remove(stack.size() - 1);
        }
      }
    }
  }

  void addPath(String word1, String word2, boolean flip) {
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

  void dfs(List<List<String>> lists, List<String> list, int type) {
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
    List<List<String>> paths = new Solution().findLadders("magic", "pearl",
        Arrays.asList("flail","halon","lexus","joint","pears","slabs","lorie","lapse","wroth","yalow","swear","cavil","piety","yogis","dhaka","laxer","tatum","provo","truss","tends","deana","dried","hutch","basho","flyby","miler","fries","floes","lingo","wider","scary","marks","perry","igloo","melts","lanny","satan","foamy","perks","denim","plugs","cloak","cyril","women","issue","rocky","marry","trash","merry","topic","hicks","dicky","prado","casio","lapel","diane","serer","paige","parry","elope","balds","dated","copra","earth","marty","slake","balms","daryl","loves","civet","sweat","daley","touch","maria","dacca","muggy","chore","felix","ogled","acids","terse","cults","darla","snubs","boats","recta","cohan","purse","joist","grosz","sheri","steam","manic","luisa","gluts","spits","boxer","abner","cooke","scowl","kenya","hasps","roger","edwin","black","terns","folks","demur","dingo","party","brian","numbs","forgo","gunny","waled","bucks","titan","ruffs","pizza","ravel","poole","suits","stoic","segre","white","lemur","belts","scums","parks","gusts","ozark","umped","heard","lorna","emile","orbit","onset","cruet","amiss","fumed","gelds","italy","rakes","loxed","kilts","mania","tombs","gaped","merge","molar","smith","tangs","misty","wefts","yawns","smile","scuff","width","paris","coded","sodom","shits","benny","pudgy","mayer","peary","curve","tulsa","ramos","thick","dogie","gourd","strop","ahmad","clove","tract","calyx","maris","wants","lipid","pearl","maybe","banjo","south","blend","diana","lanai","waged","shari","magic","duchy","decca","wried","maine","nutty","turns","satyr","holds","finks","twits","peaks","teems","peace","melon","czars","robby","tabby","shove","minty","marta","dregs","lacks","casts","aruba","stall","nurse","jewry","knuth"));
    for (List<String> path : paths)
      System.out.println(Arrays.toString(path.toArray()));
  }
}
