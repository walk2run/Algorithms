# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param two ListNodes
    # @return a ListNode
    def mergeTwoLists(self, l1, l2):
        head = p = ListNode(0)
        while l1 or l2:
            if l1 and l2:
                if l1.val < l2.val:
                    p, l1 = insert(p, l1)
                else:
                    p, l2 = insert(p, l2)
            elif l1:
                p, l1 = insert(p, l1)
            elif l2:
                p, l2 = insert(p, l2)
        return head.next
    
def insert(p, l):
    p.next = l
    l = l.next
    p = p.next
    p.next = None
    return p, l