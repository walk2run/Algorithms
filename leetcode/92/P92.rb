# Definition for singly-linked list.
# class ListNode
#     attr_accessor :val, :next
#     def initialize(val)
#         @val = val
#         @next = nil
#     end
# end

# @param {ListNode} head
# @param {Integer} m
# @param {Integer} n
# @return {ListNode}
def reverse_between(head, m, n)
	return head if m == n
	p = head
	(m - 2).times do
		p = p.next
	end
	if m == 1
		p0 = nil
		p1 = head
	else
		p0 = p
		p1 = p.next
	end
	q = p1
	p = p1.next
	(m...n).each do
		pNext = p.next
		p.next = q
		q = p
		p = pNext
	end
	p1.next = p
	if p0
		p0.next = q
		head
	else
		q
	end
end

reverse_between 0, 3, 5

