# Remove Duplicates from Sorted List II

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
	return nil if !head
	lastNode = p = head
	count = 0
	tail = node = ListNode.new 0
	while p
		if p.val != lastNode.val
			if count == 1
				tail.next = lastNode
				tail = lastNode
			end
			lastNode = p
			count = 1
		else
			count += 1
		end
		p = p.next
	end
	tail.next = count ==1 ? lastNode : nil
	node.next
end

