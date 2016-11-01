/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
	public int maxDepth(TreeNode root) {
		search(root, 0);
		return max;
	}
	
	void search(TreeNode root, int i) {
		if (root == null) {
			if (i > max) max = i;
			return;
		}
		search(root.left, i + 1);
		search(root.right, i + 1);
	}
	
	int max = 0;
}