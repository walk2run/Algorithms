/**
 * Created by yfy on 8/6/17.
 * 234. Palindrome Linked List
 */

class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}

class Solution {
  public boolean isPalindrome(ListNode head) {
    ListNode slow, fast;
    slow = fast = head;
    while (fast != null) {
      slow = slow.next;
      fast = fast.next;
      if (fast == null) break;
      fast = fast.next;
    }

  }
}

public class P234 {
}
