# 100. Same Tree
# Definition for a binary tree node.
# class TreeNode
#     attr_accessor :val, :left, :right
#     def initialize(val)
#         @val = val
#         @left, @right = nil, nil
#     end
# end

# @param {TreeNode} p
# @param {TreeNode} q
# @return {Boolean}
def is_same_tree(p, q)
	if !p && !q
		true
	elsif p && q
		p.val == q.val && is_same_tree(p.left, q.left) && is_same_tree(p.right, q.right)
	else
		false
	end
end

