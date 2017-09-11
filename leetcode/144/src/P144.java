// 144. Binary Tree Preorder Traversal

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
  public List<Integer> preorderTraversal(TreeNode root) {
    list = new ArrayList<>();
    dfs(root);
    return list;
  }

  void dfs(TreeNode node) {
    if (node == null) return;
    list.add(node.val);
    dfs(node.left);
    dfs(node.right);
  }

  List<Integer> list;
}

public class P144 {
}
