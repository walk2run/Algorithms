# 114. Flatten Binary Tree to Linked List
# Definition for a binary tree node.
# class TreeNode
#     attr_accessor :val, :left, :right
#     def initialize(val)
#         @val = val
#         @left, @right = nil, nil
#     end
# end

# @param {TreeNode} root
# @return {Void} Do not return anything, modify root in-place instead.
def flatten(root)
	search root if root
end

def search node
	tail, right = node, node.right
	if node.left
		node.right = node.left
		tail = search node.left
		node.left = nil
	end
	if right
		tail.right = right
		tail = search right
	end
	tail
end

