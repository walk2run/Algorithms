import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by qwordy on 2/24/16.
 * 103. Binary Tree Zigzag Level Order Traversal
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

class Solution {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> valLists = new ArrayList<>();
		if (root == null)
			return valLists;
		List<TreeNode> nodeList = Collections.singletonList(root);
		List<Integer> valList = Collections.singletonList(root.val);
		valLists.add(valList);
		boolean dirct = false;
		while (!nodeList.isEmpty()) {
			valList = new ArrayList<>();
			List<TreeNode> newNodeList = new ArrayList<>();
			ListIterator<TreeNode> it = nodeList.listIterator(nodeList.size());
			while (it.hasPrevious()) {
				TreeNode node = it.previous();
				if (dirct) {
					addNode(node.left, newNodeList, valList);
					addNode(node.right, newNodeList, valList);
				} else {
					addNode(node.right, newNodeList, valList);
					addNode(node.left, newNodeList, valList);
				}
			}
			dirct = !dirct;
			if (!valList.isEmpty())
				valLists.add(valList);
			nodeList = newNodeList;
		}
		return valLists;
	}

	private void addNode(TreeNode node, List<TreeNode> nodeList, List<Integer> valList) {
		if (node != null) {
			nodeList.add(node);
			valList.add(node.val);
		}
	}
}

public class P103 {
}
