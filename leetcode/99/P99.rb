# 99. Recover Binary Search Tree
# Definition for a binary tree node.
# class TreeNode
#     attr_accessor :val, :left, :right
#     def initialize(val)
#         @val = val
#         @left, @right = nil, nil
#     end
# end

# @param {TreeNode} root
# @return {Void} Do not return anything, modify root in-place instead.
def recover_tree(root)
	$node1 = $node2 = $prev = nil
	search root
	val = $node1.val
	$node1.val = $node2.val
	$node2.val = val
end

def search node
	return if node == nil
	search node.left
	if $prev != nil
		if node.val < $prev.val
			$node1 = $prev if $node1 == nil
			$node2 = node
		end
	end
	$prev = node
	search node.right
end

