/**
 * Created by qwordy on 2/24/16.
 * 109. Convert Sorted List to Binary Search Tree
 */

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

class Solution {
	public TreeNode sortedListToBST(ListNode head) {
		int len = 0;
		ListNode p = head;
		while (p != null) {
			p = p.next;
			len++;
		}
		node = head;
		return build(0, len - 1);
	}

	private TreeNode build(int l, int r) {
		if (l > r) return null;
		int mid = (l + r) / 2;
		TreeNode left = build(l, mid - 1);
		TreeNode root = new TreeNode(node.val);
		node = node.next;
		root.left = left;
		root.right = build(mid + 1, r);
		return root;
	}

	private ListNode node;
}

public class P109 {
}
