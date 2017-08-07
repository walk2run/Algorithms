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
    ListNode slow, fast, next, prev;
    slow = fast = head;
    while (fast != null) {
      slow = slow.next;
      fast = fast.next;
      if (fast == null) break;
      fast = fast.next;
    }
    prev = null;
    while (slow != null) {
      next = slow.next;
      slow.next = prev;
      prev = slow;
      slow = next;
    }
    slow = head;
    while (prev != null && slow.val == prev.val) {
      prev = prev.next;
      slow = slow.next;
    }
    return prev == null;
  }
}

public class P234 {
}
