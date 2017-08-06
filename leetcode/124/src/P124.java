/**
 * Created by yfy on 8/6/17.
 * 124. Binary Tree Maximum Path Sum
 */

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}

class Solution {
  int max = Integer.MIN_VALUE;

  public int maxPathSum(TreeNode root) {
    dfs(root);
    return max;
  }

  int dfs(TreeNode node) {
    if (node == null) return 0;
    int leftSum = dfs(node.left);
    int rightSum = dfs(node.right);
    max = Math.max(max, leftSum + rightSum + node.val);
    return Math.max(Math.max(leftSum, rightSum) + node.val, 0);
  }
}

public class P124 {
}
