# 101. Symmetric Tree
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
def is_symmetric(root)
	!root || sym(root.left, root.right) ? true : false
end

def sym p, q
	!p && !q || p && q && p.val == q.val && sym(p.left, q.right) && sym(p.right, q.left)
end

