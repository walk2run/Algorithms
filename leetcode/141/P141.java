/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode n1, n2;
        n1 = n2 = head;
        while (true) {
            n1 = n1.next;
            n2 = n2.next;
            if (n2 == null) return false;
            n2 = n2.next;
            if (n2 == null) return false;
            if (n1 == n2) return true;
        }
    }
}