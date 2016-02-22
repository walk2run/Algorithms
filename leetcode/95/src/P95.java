/**
 * Created by qwordy on 2/22/16.
 * 95. Unique Binary Search Trees II
 */

import java.util.ArrayList;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

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
	public List<TreeNode> generateTrees(int n) {
		if (n == 0) return new ArrayList<>();
		return search(1, n);
	}

	private List<TreeNode> search(int left, int right) {
		List<TreeNode> list = new ArrayList<>();
		if (left > right) {
			list.add(null);
			return list;
		}
		for (int i = left; i <= right; i++) {
			List<TreeNode> listLeft = search(left, i - 1);
			List<TreeNode> listRight = search(i + 1, right);
			for (TreeNode treeLeft : listLeft) {
				for (TreeNode treeRight : listRight) {
					TreeNode root = new TreeNode(i);
					root.left = treeLeft;
					root.right = treeRight;
					list.add(root);
				}
			}
		}
		return list;
	}
}

public class P95 {
}
