# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @return a ListNode
    def addTwoNumbers(self, l1, l2):
        q = head = ListNode(0)
        carry = 0
        while True:
            val1 = l1.val if l1 else 0
            val2 = l2.val if l2 else 0
            s = val1 + val2 + carry
            carry = s // 10
            p = ListNode(s % 10)
            if not l1 and not l2:
                if p.val > 0:
                    q.next = p
                return head.next
            q.next = p
            q = p
            if l1:
                l1 = l1.next
            if l2:
                l2 = l2.next
            
