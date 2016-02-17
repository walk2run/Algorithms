# 95. Unique Binary Search Trees II
# Definition for a binary tree node.
# class TreeNode
#     attr_accessor :val, :left, :right
#     def initialize(val)
#         @val = val
#         @left, @right = nil, nil
#     end
# end

# @param {Integer} n
# @return {TreeNode[]}
def generate_trees(n)
	return [] if n == 0
	search 1, n
end

# @return {TreeNode[]}
def search left, right
	list = []
	if left > right
		list << nil
		return list
	end	
	for i in left..right
		listLeft = search left, i - 1
		listRight = search i + 1, right
		listLeft.each do |treeLeft|
			listRight.each do |treeRight|
				root = TreeNode.new i
				root.left = treeLeft
				root.right = treeRight
				list << root
			end
		end
	end
	list
end

