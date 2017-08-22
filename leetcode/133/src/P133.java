import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yfy on 8/22/17.
 * 133. Clone Graph
 */

class UndirectedGraphNode {
  int label;
  List<UndirectedGraphNode> neighbors;

  UndirectedGraphNode(int x) {
    label = x;
    neighbors = new ArrayList<UndirectedGraphNode>();
  }
}

public class Solution {
  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    if (node == null) return null;
    if (map.containsKey(node.label))
      return map.get(node.label);
    UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
    map.put(newNode.label, newNode);
    for (UndirectedGraphNode nb : node.neighbors)
      newNode.neighbors.add(cloneGraph(nb));
    return newNode;
  }

  Map<Integer, UndirectedGraphNode> map = new HashMap<>();
}

public class P133 {
}
