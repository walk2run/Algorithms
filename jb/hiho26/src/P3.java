import java.util.Scanner;

public class P3 {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    k = scan.nextInt();
    Node root = new Node(1, n);
    for (int i = 0; i < n; i++) {
      int a = Integer.parseInt(scan.next());
      if (add(root, a)) {
        System.out.println(i + 1);
        return;
      }
    }
    System.out.println(-1);
  }

  static int k;

  static boolean add(Node root, int a) {
    while (true) {
      if (root.left == null && root.right == null) {
        if (root.begin == root.end) return false;
        if (root.begin == a) {
          root.begin = a + 1;
          return root.end - a == k;
        }
        if (root.end == a) {
          root.end = a - 1;
          return a - root.begin == k;
        }
        root.left = new Node(root.begin, a - 1);
        root.right = new Node(a + 1, root.end);
        return a - root.begin == k || root.end - a == k;
      }
      if (a >= root.left.begin && a <= root.left.end)
        root = root.left;
      else
        root = root.right;
    }
  }
}

class Node {
  int begin, end;
  Node left, right;

  public Node(int begin, int end) {
    this.begin = begin;
    this.end = end;
  }
}
