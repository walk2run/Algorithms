# 94. Binary Tree Inorder Traversal
# Definition for a binary tree node.
# class TreeNode
#     attr_accessor :val, :left, :right
#     def initialize(val)
#         @val = val
#         @left, @right = nil, nil
#     end
# end

# @param {TreeNode} root
# @return {Integer[]}
def inorder_traversal(root)
	p = root
	list = []
	while p
		if p.left == nil
			list << p.val
			p = p.right
		else
			prev = p.left
			while prev.right && prev.right != p
				prev = prev.right
			end
			if prev.right == nil
				prev.right = p
				p = p.left
			else
				prev.right = nil
				list << p.val
				p = p.right
			end
		end
	end
	list
end
