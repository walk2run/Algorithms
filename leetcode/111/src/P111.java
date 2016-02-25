import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yfy on 2/25/16.
 * 111. Minimum Depth of Binary Tree
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

class Solution {
	private class Node {
		TreeNode node;
		int depth;
		Node(TreeNode n, int d) { node = n; depth = d; }
	}

	public int minDepth(TreeNode root) {
		if (root == null) return 0;
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(root, 1));
		while (!queue.isEmpty()) {
			Node node = queue.remove();
			if (node.node.left == null && node.node.right == null)
				return node.depth;
			if (node.node.left != null)
				queue.add(new Node(node.node.left, node.depth + 1));
			if (node.node.right != null)
				queue.add(new Node(node.node.right, node.depth + 1));
		}
		return 0;
	}
}

public class P111 {
}
