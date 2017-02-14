import java.util.*;

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}

public class Tree {
  private TreeNode maxNode, minNode;
  private List<Character> maxPath, minPath, path = new ArrayList<>();
  
  public int getDis(TreeNode root) {
    dfs(root);
    int i;
    for (i = 0; i < maxPath.size() && i < minPath.size(); i++) {
      if (maxPath.get(i) != minPath.get(i)) break;
    }
    return maxPath.size() + minPath.size() - i * 2;
  }
  
  public void dfs(TreeNode n) {
    if (n == null) return;
    if (n.left == null && n.right == null) {
      if (maxNode == null || n.val > maxNode.val) {
        maxNode = n;
        maxPath = new ArrayList<>(path);
      }
      if (minNode == null || n.val < minNode.val) {
        minNode = n;
        minPath = new ArrayList<>(path);
      }
    }
    path.add('0');
    dfs(n.left);
    path.remove(path.size() - 1);
    path.add('1');
    dfs(n.right);
    path.remove(path.size() - 1);
  }
}