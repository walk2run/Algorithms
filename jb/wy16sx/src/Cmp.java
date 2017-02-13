import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by yfy on 2017/2/13.
 */

class Node {
  Node(int n) { name = n; }
  int name;
  List<Node> list = new LinkedList<>();
}

class Graph {
  private Map<Integer, Node> map = new HashMap<>();

  public void add(int a, int b) {
    Node node1 = map.get(a);
    if (node1 == null) {
      node1 = new Node(a);
      map.put(a, node1);
    }
    Node node2 = map.get(b);
    if (node2 == null)
      node2 = new Node(b);
      map.put(b, node2);
    node1.list.add(node2);
  }

  public boolean exist(int a, int b) {
    Node node = map.get(a);
    if (node == null) return false;
    for (Node next : node.list) {
      if (next.name == b) return true;
      if (exist(next.name, b)) return true;
    }
    return false;
  }
}

public class Cmp {
  public int cmp(int g1, int g2, int[][] records, int n) {
    Graph graph = new Graph();
    for (int i = 0; i < n; i++)
      graph.add(records[i][0], records[i][1]);
    boolean b1 = graph.exist(g1, g2);
    boolean b2 = graph.exist(g2, g1);
    if (b1) return 1;
    if (b2) return -1;
    return 0;
  }

  public static void main(String[] args) {
    int[][] r = new int[][] {{1, 2}, {2, 4}, {1, 3}, {4, 3}};
    System.out.println(new Cmp().cmp(2, 3, r, 4));
  }
}