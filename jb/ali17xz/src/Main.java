import java.util.*;

/**
 * Created by yfy on 8/25/2017.
 */
public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    List<Line> lineList = new ArrayList<Line>();
    while (scanner.hasNextLine()) {
      String[] options = scanner.nextLine().split(";");
      if (options.length < 5) {
        break;
      }
      lineList.add(new Line(options[0], options[1], options[2], options[3], options[4], options[5]));
    }
    scanner.close();

    // wirte your code here
    List<String> result = calculateUnilateral(lineList);

    for (String str : result) {
      System.out.println(str);
    }
  }

  public static List<String> calculateUnilateral(List<Line> lineList) {
    List<String> result = new ArrayList<String>();

    for (Line line : lineList) {
      Pair pair = new Pair(line.sCen, line.eCen);
      List<Line> list = map.get(pair);
      if (list == null) {
        list = new ArrayList<>();
        map.put(pair, list);
      }
      list.add(line);

      // edgesMap
      list = edgesMap.get(line.sCen);
      if (list == null) {
        list = new ArrayList<>();
        edgesMap.put(line.sCen, list);
      }
      list.add(line);
    }

    // rule1
    for (Line l1 : lineList) {
      List<Line> list = map.get(new Pair(l1.eCen, l1.sCen));  // reverse
      if (list != null) {
        List<Integer> listSmallIndex = new ArrayList<>();
        boolean find = false;
        int j = 0;
        for (Line l2 : list) {
          if (l1.tType.equals("17.5m") && l2.tType.equals("9.6m") && listSmallIndex.size() < 2)
            listSmallIndex.add(j);
          if (l1.tType.equals(l2.tType)) {
            find = true;
            result.add("rule1:" + l1.id + '+' + l2.id);
            list.remove(j);
            List<Line> list2 = map.get(new Pair(l1.sCen, l1.eCen));
            list2.remove(l1);
            break;
          }
          j++;
        }
        if (!find && l1.tType.equals("17.5m") && listSmallIndex.size() >= 2) {
          int pos1 = listSmallIndex.get(0);
          int pos2 = listSmallIndex.get(1);
          result.add("rule1:" + l1.id + '+' + list.get(pos1) + '+' + list.get(pos2));
          List<Line> list2 = map.get(new Pair(l1.sCen, l1.eCen));
          list2.remove(l1);
          list.remove(pos1);
          list.remove(pos2);
        }
      }
    }

    // rule2
    for (Line line : lineList) {
      List<Line> edges0 = edgesMap.get(line.sCen);
      if (!edges0.contains(line)) continue;
      List<Line> edges = edgesMap.get(line.eCen);
      if (edges == null) continue;
      boolean find = false;
      for (Line line2 : edges) {
        if (!line2.tType.equals(line.tType))
          continue;
        List<Line> edges2 = edgesMap.get(line2.eCen);
        if (edges2 == null) continue;
        for (Line line3 : edges2) {
          if (!line3.tType.equals(line.tType))
            continue;
          if (line3.eCen.equals(line.sCen)) {
            result.add("rule2:" + line.id + '+' + line2.id + '+' + line3.id);
            edges.remove(line2);
            edges2.remove(line3);
            edgesMap.get(line.sCen).remove(line);
            find = true;
            break;
          }
        }
        if (find) break;
      }
    }

    // rule3


    return result;
  }

  static Map<Pair, List<Line>> map = new HashMap<>();

  static Map<String, List<Line>> edgesMap = new HashMap<>();

  static class Pair {
    @Override
    public int hashCode() {
      return start.hashCode() + end.hashCode() ;
    }

    @Override
    public boolean equals(Object obj) {
      Pair p = (Pair) obj;
      return p.start.equals(start) && p.end.equals(end);
    }

    String start, end;

    public Pair(String start, String end) {
      this.start = start;
      this.end = end;
    }
  }

  public static class Line {
    String id;
    String sCen;//出发分拨
    String sPro;//出发省
    String eCen;//到达分拨
    String ePro;//到达省
    //9.6m/17.5m
    String tType;//车型
    public Line(String id, String sCen, String sPro, String eCen, String ePro, String tType) {
      this.id = id;this.sCen = sCen;this.sPro = sPro;this.eCen = eCen;this.ePro = ePro;this.tType = tType;}
    public String getId() {return id;}
    public void setId(String id) {this.id = id;}
    public String getSCen() {return sCen;}
    public void setSCen(String ePro) {this.ePro = ePro;}
    public String getSPro() {return sPro;}
    public void setSPro(String sPro) {this.sPro = sPro;}
    public String getECen() {return eCen;}
    public void setECen(String eCen) {this.eCen = eCen;}
    public String getEPro() {return ePro;}
    public void setEPro(String ePro) {this.ePro = ePro;}
    public String getTType() {return tType;}
    public void setTType(String tType) {this.tType = tType;}
  }
}
