/**
 * Created by qwordy on 2/24/16.
 * 108. Convert Sorted Array to Binary Search Tree
 */

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

class Solution {
	public TreeNode sortedArrayToBST(int[] nums) {
		return build(nums, 0, nums.length - 1);
	}

	private TreeNode build(int[] nums, int l, int r) {
		if (l > r) return null;
		int mid = (l + r) / 2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = build(nums, l, mid - 1);
		node.right = build(nums, mid + 1, r);
		return node;
	}
}

public class P108 {
}
