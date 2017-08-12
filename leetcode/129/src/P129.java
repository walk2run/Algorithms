/**
 * Created by yfy on 8/12/17.
 * 129. Sum Root to Leaf Numbers
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
  public int sumNumbers(TreeNode root) {
    dfs(root, 0);
    return sum;
  }

  int sum = 0;

  void dfs(TreeNode node, int par) {
    if (node == null) return;
    int cur = par * 10 + node.val;
    if (node.left == null && node.right == null) {
      sum += cur;
    } else {
      dfs(node.left, cur);
      dfs(node.right, cur);
    }
  }
}

public class P129 {
}
