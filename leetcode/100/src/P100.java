/**
 * Created by qwordy on 2/22/16.
 * 100. Same Tree
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

class Solution {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		return p == null && q == null || p != null && q != null && p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}
}

public class P100 {
}
