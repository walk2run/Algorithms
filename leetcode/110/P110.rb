# 110. Balanced Binary Tree
# Definition for a binary tree node.
# class TreeNode
#     attr_accessor :val, :left, :right
#     def initialize(val)
#         @val = val
#         @left, @right = nil, nil
#     end
# end

# @param {TreeNode} root
# @return {Boolean}
def is_balanced(root)
	height(root) >= 0
end

def height root
	return 0 if !root
	lh = height root.left
	return -1 if lh < 0
	rh = height root.right
	return -1 if rh < 0
	if (lh - rh).abs <= 1
		[lh, rh].max + 1
	else
		-1
	end
end

