import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by qwordy on 2/24/16.
 * 107. Binary Tree Level Order Traversal II
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

class Solution {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> valLists = new ArrayList<>();
		if (root == null)
			return valLists;
		List<TreeNode> nodeList = Collections.singletonList(root);
		List<Integer> valList = Collections.singletonList(root.val);
		valLists.add(valList);
		while (!nodeList.isEmpty()) {
			valList = new ArrayList<>();
			List<TreeNode> newNodeList = new ArrayList<>();
			for (TreeNode node : nodeList) {
				if (node.left != null) {
					newNodeList.add(node.left);
					valList.add(node.left.val);
				}
				if (node.right != null) {
					newNodeList.add(node.right);
					valList.add(node.right.val);
				}
			}
			if (!valList.isEmpty())
				valLists.add(valList);
			nodeList = newNodeList;
		}
		Collections.reverse(valLists);
		return valLists;
	}
}

public class P107 {
}
