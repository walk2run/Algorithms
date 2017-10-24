import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P4 {
  public static void main(String[] args) throws Exception {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    Map<String, String> map = new TreeMap<>();
    Map<String, Map<String, String>> ss = new TreeMap<>();
    scan.nextLine();
    for (int i = 0; i < n; i++) {
      String str = scan.nextLine();
      String[] strs = str.split(" ");
      if (strs[0].equals("put")) {
        map.put(strs[1], strs[2]);
      } else if (strs[0].equals("mkss")) {
        ss.put(strs[1], new HashMap<>(map));
      } else if (strs[0].equals("get")) {
        if (strs.length == 2) {
          System.out.println(getOrDefault(map, strs[1], "(NULL)"));
        } else {
          Map<String, String> s = ss.get(strs[2]);
          if (s == null)
            System.out.println("(UNKNOWN_SSID)");
          else
            System.out.println(getOrDefault(s, strs[1], "(NULL)"));
        }
      } else if (strs[0].equals("del")) {
        map.remove(strs[1]);
      }
    }
  }

  static String getOrDefault(Map<String, String> map, String key, String def) {
    String v = map.get(key);
    if (v == null) return def;
    return v;
  }
}
