# 103. Binary Tree Zigzag Level Order Traversal
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
def zigzag_level_order(root)
	valLists = []
	if root == nil
		return valLists
	end
	nodeList = [root]
	valLists << [root.val]
	dirct = false
	while !nodeList.empty?
		valList = []
		newNodeList = []
		nodeList.reverse_each do |node|
			if dirct
				addNode node.left, newNodeList, valList
				addNode node.right, newNodeList, valList
			else
				addNode node.right, newNodeList, valList
				addNode node.left, newNodeList, valList
			end
		end
		dirct = !dirct
		if !valList.empty?
			valLists << valList
		end
		nodeList = newNodeList
	end
	valLists
end

def addNode node, nodeList, valList
	if node
		nodeList << node
		valList << node.val
	end
end

