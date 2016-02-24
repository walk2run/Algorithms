# 107. Binary Tree Level Order Traversal II
# Definition for a binary tree node.
# class TreeNode
#     attr_accessor :val, :left, :right
#     def initialize(val)
#         @val = val
#         @left, @right = nil, nil
#     end
# end

# @param {TreeNode} root
# @return {Integer[][]}
def level_order_bottom(root)
	valLists = []
	if root == nil
		return valLists
	end
	nodeList = [root]
	valLists << [root.val]
	while !nodeList.empty?
		valList = []
		newNodeList = []
		nodeList.each do |node|
			if node.left
				newNodeList << node.left
				valList << node.left.val
			end
			if node.right
				newNodeList << node.right
				valList << node.right.val
			end
		end
		if !valList.empty?
			valLists << valList
		end
		nodeList = newNodeList
	end
	valLists.reverse!
end

