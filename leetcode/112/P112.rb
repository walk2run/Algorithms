# 112. Path Sum
# Definition for a binary tree node.
# class TreeNode
#     attr_accessor :val, :left, :right
#     def initialize(val)
#         @val = val
#         @left, @right = nil, nil
#     end
# end

# @param {TreeNode} root
# @param {Integer} sum
# @return {Boolean}
def has_path_sum(root, sum)
	(root && search(root, sum, 0)) ? true : false
end

def search node, sum, crtSum
	crtSum += node.val
	!node.left && !node.right && crtSum == sum || node.left && search(node.left, sum, crtSum) || node.right && search(node.right, sum, crtSum)
end

