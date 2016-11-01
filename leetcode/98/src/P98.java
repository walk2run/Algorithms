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
	public boolean isValidBST(TreeNode root) {
		return search(root);
	}

	boolean search(TreeNode root) {
		if (root == null) return true;
		if (!search(root.left)) return false;
		if (!compare(root.val)) return false;
		if (!search(root.right)) return false;
		return true;
	}
	
	boolean compare(int val) {
		boolean valid = val > prev;
		prev = val;
		return valid;
	}
	
	int prev = Integer.MIN_VALUE;
}
