/*
ID: iamyfy1
PROG: namenum
LANG: JAVA
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;

/**
 * Created by yfy on 2016/11/2.
 */
public class namenum {
  private static int[] map = new int[]{2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5,
      6, 6, 6, 7, -1, 7, 7, 8, 8, 8, 9, 9, 9, -1};

  private static boolean find;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new FileReader("namenum.in"));
    String num = br.readLine();
    int numLen = num.length();
    br = new BufferedReader(new FileReader("dict.txt"));
    String word;
    PrintWriter pw = new PrintWriter("namenum.out");
    while ((word = br.readLine()) != null)
      if (match(num, word)) pw.println(word);
    if (!find) pw.println("NONE");
    pw.close();
  }

  private static boolean match(String num, String word) {
    if (num.length() != word.length()) return false;
    for (int i = 0; i < num.length(); i++)
      if (map[word.charAt(i) - 'A'] != num.charAt(i) - '0') return false;
    find = true;
    return true;
  }
}
