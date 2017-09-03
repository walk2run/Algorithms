/*
ID: iamyfy1
PROG: prefix
LANG: JAVA
 */

import java.io.File;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by yfy on 7/19/17.
 */

class Trie {
  Node root;

  Trie() {
    root = new Node(' ');
  }

  void add(String word) {
    Node node = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      Node child = node.map.get(ch);
      if (child == null) {
        child = new Node(ch);
        node.map.put(ch, child);
      }
      node = child;
    }
    node.end = true;
  }

  boolean find(String word, boolean[] f, int p) {
    Node node = root;
    for (int i = 0; i < word.length(); i++) {
      char ch = word.charAt(i);
      Node child = node.map.get(ch);
      if (child == null) return false;
      if (child.end && (p == i || f[p - i - 1])) return true;
      node = child;
    }
    return false;
  }

  static class Node {
    Map<Character, Node> map;
    char ch;
    boolean end;
    Node(char ch) {
      map = new HashMap<>();
      this.ch = ch;
    }
  }
}

public class prefix {
  public static void main(String[] args) throws Exception {
    Scanner scan = new Scanner(new File("prefix.in"));
    //List<String> tokens = new ArrayList<>();
    int maxLen = 0;
    String token;
    Trie trie = new Trie();
    while (!(token = scan.next()).equals(".")) {
      //tokens.add(token);
      trie.add(new StringBuilder(token).reverse().toString());
      maxLen = Math.max(token.length(), maxLen);
    }
    StringBuilder sb = new StringBuilder();
    while (scan.hasNext())
      sb.append(scan.next());
    String seq = sb.toString();

    int n = seq.length();
    boolean[] f = new boolean[n];
    for (int i = 0; i < n; i++) {
      String word = new StringBuilder(seq.substring(Math.max(0, i - maxLen + 1), i + 1)).reverse().toString();
      if (trie.find(word, f, i)) f[i] = true;
      /*for (String t : tokens) {
        int len = t.length();
        int prev = i - len;
        if (prev < -1 || prev > -1 && !f[prev]) continue;
        if (seq.substring(prev + 1, prev + 1 + len).equals(t)) {
          f[i] = true;
          break;
        }
      }*/
    }
    int i = n - 1;
    while (i >= 0 && !f[i]) i--;

    PrintWriter pw = new PrintWriter("prefix.out");
    pw.println(i + 1);
    pw.close();
  }
}
