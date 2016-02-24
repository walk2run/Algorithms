/**
 * Created by qwordy on 2/24/16.
 * 106. Construct Binary Tree from Inorder and Postorder Traversal
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

class Solution {
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		this.inorder = inorder;
		this.postorder = postorder;
		return build(0, inorder.length - 1, postorder.length - 1);
	}

	private TreeNode build(int i0, int i1, int p1) {
		int i;
		if (i0 > i1) return null;
		TreeNode node = new TreeNode(postorder[p1]);
		for (i = i0; i <= i1; i++)
			if (inorder[i] == postorder[p1])
				break;
		node.left = build(i0, i - 1, p1 - i1 + i - 1);
		node.right = build(i + 1, i1, p1 - 1);
		return node;
	}

	int[] inorder, postorder;
}

public class P106 {
}
