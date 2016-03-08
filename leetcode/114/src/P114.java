/**
 * Created by qwordy on 2/26/16.
 * 114. Flatten Binary Tree to Linked List
 */

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}

class Solution {
  public void flatten(TreeNode root) {
    if (root != null) search(root);
  }

  // Return the last node
  private TreeNode search(TreeNode node) {
    TreeNode tail = node;
    TreeNode right = node.right;
    if (node.left != null) {
      node.right = node.left;
      tail = search(node.left);
      node.left = null;
    }
    if (right != null) {
      tail.right = right;
      tail = search(right);
    }
    return tail;
  }
}

public class P114 {
}
