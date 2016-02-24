/**
 * Created by qwordy on 2/24/16.
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

class Solution {
	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return build(preorder, inorder, 0, 0, inorder.length  - 1);
	}

	private TreeNode build(int[] preorder, int[] inorder, int p0, int i0, int i1) {
		int i;
		if (i0 > i1) return null;
		TreeNode node = new TreeNode(preorder[p0]);
		for (i = i0; i <= i1; i++)
			if (inorder[i] == preorder[p0])
				break;
		node.left = build(preorder, inorder, p0 + 1, i0, i - 1);
		node.right = build(preorder, inorder, p0 + i - i0 + 1, i + 1, i1);
		return node;
	}
}

public class P105 {
}
