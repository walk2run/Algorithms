# 111. Minimum Depth of Binary Tree
# Definition for a binary tree node.
# class TreeNode
#     attr_accessor :val, :left, :right
#     def initialize(val)
#         @val = val
#         @left, @right = nil, nil
#     end
# end

class Node
	attr_accessor :node, :depth

	def initialize node, depth
		@node = node
		@depth = depth
	end
end

# @param {TreeNode} root
# @return {Integer}
def min_depth(root)
	return 0 if !root
    queue = []
	queue << Node.new(root, 1)
	while !queue.empty?
		node = queue.shift
		if !node.node.left && !node.node.right
			return node.depth
		end
		if node.node.left
			queue << Node.new(node.node.left, node.depth + 1)
		end
		if node.node.right
			queue << Node.new(node.node.right, node.depth + 1)
		end
	end
end

