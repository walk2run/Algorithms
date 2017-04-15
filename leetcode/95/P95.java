import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
  public List<TreeNode> generateTrees(int n) {
    if (n == 0) return new ArrayList<>();
    lists = new List[n + 1][n + 1];
    return search(1, n);
  }
  
  private List<TreeNode>[][] lists;
  
  private List<TreeNode> search(int l, int r) {
    List<TreeNode> list = new ArrayList<>();
    if (l > r) {
      list.add(null);
      return list;
    }
    if (lists[l][r] != null)
      return lists[l][r];
    for (int i = l; i <= r; i++) {
      List<TreeNode> list1 = search(l, i - 1);
      List<TreeNode> list2 = search(i + 1, r);
      for (TreeNode node1 : list1) {
        for (TreeNode node2 : list2) {
          TreeNode n = new TreeNode(i);
          n.left = node1;
          n.right = node2;
          list.add(n);
        }
      }
    }
    lists[l][r] = list;
    return list;
  }
}