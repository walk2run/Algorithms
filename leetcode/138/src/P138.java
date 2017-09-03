// 138. Copy List with Random Pointer

import java.util.HashMap;
import java.util.Map;

class RandomListNode {
  int label;
  RandomListNode next, random;
  RandomListNode(int x) {
    this.label = x;
  }
}

class Solution {
  public RandomListNode copyRandomList(RandomListNode head) {
    Map<RandomListNode, RandomListNode> map = new HashMap<>();
    RandomListNode p = head, q = null, nh = null;
    while (p != null) {
      RandomListNode np = new RandomListNode(p.label);
      np.random = p.random;
      if (q == null) nh = np; else q.next = np;
      map.put(p, np);
      q = np;
      p = p.next;
    }
    p = nh;
    while (p != null) {
      p.random = map.get(p.random);
      p = p.next;
    }
    return nh;
  }
}

public class P138 {
}
