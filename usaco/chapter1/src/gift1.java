/*
ID: iamyfy1
PROG: gift1
LANG: JAVA
 */

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by yfy on 2016/10/31.
 */
public class gift1 {
//  public static void main(String[] args) throws Exception {
//    int n, i, money, m, piece;
//    StreamTokenizer st = new StreamTokenizer(new BufferedReader(new FileReader("gift1.in")));
//    st.nextToken();
//    n = (int) st.nval;
//    HashMap<String, Integer> map = new HashMap<>();
//    ArrayList<String> list = new ArrayList<>();
//    for (i = 0; i < n; i++) {
//      st.nextToken();
//      map.put(st.sval, 0);
//      list.add(st.sval);
//    }
//    while (st.nextToken() != StreamTokenizer.TT_EOF) {
//      String giver = st.sval;
//      st.nextToken();
//      money = (int) st.nval;
//      st.nextToken();
//      m = (int) st.nval;
//      if (m == 0) continue;
//      piece = money / m;
//      map.put(giver, map.get(giver) - piece * m);
//      for (i = 0; i < m; i++) {
//        st.nextToken();
//        String receiver = st.sval;
//        map.put(receiver, map.get(receiver) + piece);
//      }
//    }
//    PrintWriter writer = new PrintWriter("gift1.out");
//    for (String name : list)
//      writer.println(name + ' ' + map.get(name));
//    writer.close();
//  }

  public static void main(String[] args) throws Exception {
    int n, i, money, m, piece;
    Scanner scan = new Scanner(new BufferedInputStream(new FileInputStream("gift1.in")));
    n = scan.nextInt();
    HashMap<String, Integer> map = new HashMap<>();
    ArrayList<String> list = new ArrayList<>();
    for (i = 0; i < n; i++) {
      String name = scan.next();
      map.put(name, 0);
      list.add(name);
    }
    while (scan.hasNext()) {
      String giver = scan.next();
      money = scan.nextInt();
      m = scan.nextInt();
      if (m == 0) continue;
      piece = money / m;
      map.put(giver, map.get(giver) - piece * m);
      for (i = 0; i < m; i++) {
        String receiver = scan.next();
        map.put(receiver, map.get(receiver) + piece);
      }
    }
    PrintWriter writer = new PrintWriter("gift1.out");
    for (String name : list)
      writer.println(name + ' ' + map.get(name));
    writer.close();
  }
}
