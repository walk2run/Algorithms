# 108. Convert Sorted Array to Binary Search Tree
# Definition for a binary tree node.
# class TreeNode
#     attr_accessor :val, :left, :right
#     def initialize(val)
#         @val = val
#         @left, @right = nil, nil
#     end
# end

# @param {Integer[]} nums
# @return {TreeNode}
def sorted_array_to_bst(nums)
	build nums, 0, nums.size - 1
end

def build nums, l, r
	return nil if l > r
	mid = (l + r) / 2
	node = TreeNode.new nums[mid]
	node.left = build nums, l, mid - 1
	node.right = build nums, mid + 1, r
	node
end

