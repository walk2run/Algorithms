/**
 * Created by yfy on 2/25/16.
 * 110. Balanced Binary Tree
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

class Solution {
	public boolean isBalanced(TreeNode root) {
		return height(root) >= 0;
	}

	// Return -1 if not balanced
	private int height(TreeNode root) {
		if (root == null) return 0;
		int leftHeight = height(root.left);
		if (leftHeight < 0) return -1;
		int rightHeight = height(root.right);
		if (rightHeight < 0) return -1;
		if (Math.abs(leftHeight - rightHeight) <= 1)
			return Math.max(leftHeight, rightHeight) + 1;
		else
			return -1;
	}
}

public class P110 {
}
