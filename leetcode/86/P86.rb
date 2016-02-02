# Definition for singly-linked list.
class ListNode
    attr_accessor :val, :next
    def initialize(val)
        @val = val
        @next = nil
    end
end

# @param {ListNode} head
# @param {Integer} x
# @return {ListNode}
def partition(head, x)
	return if head == nil
	p = head
	p = p.next while p.next
	originTail = tail = p
	p = head
	q = preHead = ListNode.new 0
	q.next = head
	while p
		break if p.next == nil
		nextP = p.next
		if p.val >= x
			q.next = p.next
			p.next = nil
			tail.next = p
			tail = p
		else
			q = p
		end
		break if p == originTail
		p = nextP
	end
	preHead.next
end

node = ListNode.new 1
node.next = ListNode.new 2
node.next.next = ListNode.new 3
p partition(node, 2)

