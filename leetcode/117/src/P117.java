/**
 * Created by yfy on 2016/11/1.
 * Populating Next Right Pointers in Each Node II
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
    while (p != null) {
      p2 = c = null;
      while (p != null) {
        if (p.left != null) {
          if (p2 == null) p2 = p.left;
          if (c != null) c.next = p.left;
          if (p.right != null)
            c = p.left.next = p.right;
          else
            c = p.left;
        } else {
          if (p.right != null) {
            if (p2 == null) p2 = p.right;
            if (c != null) c.next = p.right;
            c = p.right;
          }
        }
        p = p.next;
      }
      p = p2;
    }
  }
}

public class P117 {
}
