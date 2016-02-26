/**
 * Created by qwordy on 2/26/16.
 * 112. Path Sum
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

class Solution {
	public boolean hasPathSum(TreeNode root, int sum) {
		return root != null && search(root, sum, 0);
	}

	private boolean search(TreeNode node, int sum, int crtSum) {
		crtSum += node.val;
		return node.left == null && node.right == null && crtSum == sum || node.left != null && search(node.left, sum, crtSum) || node.right != null && search(node.right, sum, crtSum);
	}
}

public class P112 {
}
