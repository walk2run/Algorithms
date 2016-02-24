# 106. Construct Binary Tree from Inorder and Postorder Traversal
# Definition for a binary tree node.
# class TreeNode
#     attr_accessor :val, :left, :right
#     def initialize(val)
#         @val = val
#         @left, @right = nil, nil
#     end
# end

# @param {Integer[]} inorder
# @param {Integer[]} postorder
# @return {TreeNode}
def build_tree(inorder, postorder)
	$inorder = inorder
	$postorder = postorder
	build 0, inorder.size - 1, postorder.size - 1
end

def build i0, i1, p1
	return nil if i0 > i1
	node = TreeNode.new $postorder[p1]
	i = $inorder.index $postorder[p1]
	node.left = build i0, i - 1, p1 - i1 + i - 1
	node.right = build i + 1, i1, p1 - 1
	node
end

