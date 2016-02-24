# 105. Construct Binary Tree from Preorder and Inorder Traversal
# Definition for a binary tree node.
# class TreeNode
#     attr_accessor :val, :left, :right
#     def initialize(val)
#         @val = val
#         @left, @right = nil, nil
#     end
# end

# @param {Integer[]} preorder
# @param {Integer[]} inorder
# @return {TreeNode}
def build_tree(preorder, inorder)
	$preorder = preorder
	$inorder = inorder
	build 0, 0, inorder.size - 1
end

def build p0, i0, i1
	return nil if i0 > i1
	node = TreeNode.new $preorder[p0]
	i = $inorder.index $preorder[p0]
	node.left = build p0 + 1, i0, i - 1
	node.right = build p0 + i - i0 + 1, i + 1, i1
	node
end

