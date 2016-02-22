/**
 * Created by qwordy on 2/22/16.
 * 101. Symmetric Tree
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

class Solution {
	public boolean isSymmetric(TreeNode root) {
		return root == null || sym(root.left, root.right);
	}

	private boolean sym(TreeNode p, TreeNode q) {
		return p == null && q == null || p != null && q != null && p.val == q.val && sym(p.left, q.right) && sym(p.right, q.left);
	}
}

public class P101 {
}
