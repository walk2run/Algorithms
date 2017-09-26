// 173. Binary Search Tree Iterator

import java.util.Stack;

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}

class Pair {
  TreeNode node;
  int status;

  public Pair(TreeNode node, int status) {
    this.node = node;
    this.status = status;
  }
}

public class BSTIterator {

  public BSTIterator(TreeNode root) {
    stack = new Stack<>();
    if (root != null)
      stack.push(new Pair(root, 0));
  }

  Stack<Pair> stack;

  /** @return whether we have a next smallest number */
  public boolean hasNext() {
    while (!stack.empty()) {
      Pair pair = stack.peek();
      if (pair.status == 0) {
        pair.status = 1;
        if (pair.node.left != null)
          stack.push(new Pair(pair.node.left, 0));
      } else if (pair.status == 1) {
        return true;
      } else {
        stack.pop();
      }
    }
    return false;
  }

  /** @return the next smallest number */
  public int next() {
    Pair pair = stack.peek();
    pair.status = 2;
    if (pair.node.right != null)
      stack.push(new Pair(pair.node.right, 0));
    return pair.node.val;
  }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */

public class P173 {
}
