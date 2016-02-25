# 109. Convert Sorted List to Binary Search Tree
# Definition for singly-linked list.
# class ListNode
#     attr_accessor :val, :next
#     def initialize(val)
#         @val = val
#         @next = nil
#     end
# end

# Definition for a binary tree node.
# class TreeNode
#     attr_accessor :val, :left, :right
#     def initialize(val)
#         @val = val
#         @left, @right = nil, nil
#     end
# end

# @param {ListNode} head
# @return {TreeNode}
def sorted_list_to_bst(head)
	len = 0
	p = head
	while p
		p = p.next
		len += 1
	end
	$node = head
	build 0, len - 1
end

def build l, r
	return nil if l > r
	mid = (l + r) / 2
	left = build l, mid - 1
	root = TreeNode.new $node.val
	$node = $node.next
	root.left = left
	root.right = build mid + 1, r
	root
end

