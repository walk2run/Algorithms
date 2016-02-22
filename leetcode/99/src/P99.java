/**
 * Created by qwordy on 2/22/16.
 * 99. Recover Binary Search Tree
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

class Solution {
	public void recoverTree(TreeNode root) {
		search(root);
		int val = node1.val;
		node1.val = node2.val;
		node2.val = val;
	}

	void search(TreeNode node) {
		if (node == null)
			return;
		search(node.left);
		if (prev != null) {
			if (node.val < prev.val) {
				if (node1 == null) node1 = prev;
				node2 = node;
			}
		}
		prev = node;
		search(node.right);
	}

	TreeNode node1, node2, prev;
}

public class P99 {
}
