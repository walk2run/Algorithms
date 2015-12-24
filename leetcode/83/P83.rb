# Remove Duplicates from Sorted List

# Definition for singly-linked list.
# class ListNode
#     attr_accessor :val, :next
#     def initialize(val)
#         @val = val
#         @next = nil
#     end
# end

# @param {ListNode} head
# @return {ListNode}
def delete_duplicates(head)
	lastNode = p = head
	while p
		if p.val != lastNode.val
			lastNode.next = p
			lastNode = p
		end
		p = p.next
	end
	if lastNode
		lastNode.next = nil
	end
	head
end

