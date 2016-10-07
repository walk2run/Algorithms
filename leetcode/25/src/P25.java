/**
 * Created by yfy on 8/28/16.
 * 25. Reverse Nodes in k-Group
 */

class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
}

class Solution {
  public ListNode reverseKGroup(ListNode head, int k) {
    if (k < 2) return head;

    int count, i;
    ListNode p, q, nextp, begin, end, beginPrev, headPrev;

    headPrev = new ListNode(0);
    headPrev.next = head;
    beginPrev = headPrev;
    begin = head;
    while (true) {
      p = begin;
      for (i = 0; i < k - 1; i++) {
        if (p == null) return headPrev.next;
        p = p.next;
      }
      end = p;
      if (p == null) return headPrev.next;

      q = begin;
      p = q.next;
      nextp = null;
      for (i = 0; i < k - 1; i++) {
        nextp = p.next;
        p.next = q;
        q = p;
        p = nextp;
      }
      begin.next = nextp;
      beginPrev.next = end;
      beginPrev = begin;
      begin = nextp;
    }
  }
}

public class P25 {
}
