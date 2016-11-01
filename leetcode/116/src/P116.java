/**
 * Created by yfy on 5/24/16.
 * 116. Populating Next Right Pointers in Each Node
 * bfs
 */

class TreeLinkNode {
  int val;
  TreeLinkNode left, right, next;
  TreeLinkNode(int x) { val = x; }
}

class Solution {
  public void connect(TreeLinkNode root) {
    if (root == null) return;
    TreeLinkNode p, p2, c;
    p = root;
    while (p.left != null) {
      p2 = p.left;
      c = null;
      while (p != null) {
        p.left.next = p.right;
        if (c != null) c.next = p.left;
        c = p.right;
        p = p.next;
      }
      p = p2;
    }
  }
}

public class P116 {
}
