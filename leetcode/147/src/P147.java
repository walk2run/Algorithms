// 147. Insertion Sort List

class ListNode {
  int val;
  ListNode next;
  ListNode(int x) { val = x; }
}

class Solution {
  public ListNode insertionSortList(ListNode head) {
    ListNode sort = new ListNode(Integer.MIN_VALUE);
    ListNode p = head;
    while (p != null) {
      ListNode n = sort, nextp = p.next;
      while (n != null) {
        if (n.next == null || n.val <= p.val && p.val <= n.next.val) {
          p.next = n.next;
          n.next = p;
          break;
        }
        n = n.next;
      }
      p = nextp;
    }
    return sort.next;
  }
}

public class P147 {
}
