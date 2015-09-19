/**
 * Created by yfy on 2015/8/16.
 * Rotate List
 */

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

class Solution {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null) return null;
		ListNode p, q;
		k = k % len(head);
		p = head;
		for (int i = 0; i < k; i++)
			p = p.next;
		if (p == head) return head;
		q = head;
		while (p.next != null) {
			q = q.next;
			p = p.next;
		}
		p.next = head;
		head = q.next;
		q.next = null;
		return head;
	}

	int len(ListNode head) {
		int l = 0;
		while (head != null) {
			l++;
			head = head.next;
		}
		return l;
	}
}

public class P61 {
	public static void main(String[] args) {

	}
}
