/**
 * Created by yfy on 2016/11/2.
 * Add Two Numbers
 */

class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
}

class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int v1, v2, sum, carry;
    ListNode head, p;
    p = head = new ListNode(0);
    carry = 0;
    while (true) {
      v1 = l1 == null ? 0 : l1.val;
      v2 = l2 == null ? 0 : l2.val;
      sum = v1 + v2 + carry;
      carry = sum / 10;
      p.next = new ListNode(sum % 10);
      if (l1 == null && l2 == null) {
        if (sum == 0) p.next = null;
        return head.next;
      }
      p = p.next;
      if (l1 != null) l1 = l1.next;
      if (l2 != null) l2 = l2.next;
    }
  }
}

public class P2 {
}
