package Binary_Search_Tree;

class Node {
  int data;
  Node left;
  Node right;

  public Node(int data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }
}

public class DeleteNode {

  public static Node insert(Node node, int val) {
    if (node == null) {
      node = new Node(val);
      return node;
    }
    if (node.data > val) {
      node.left = insert(node.left, val);

    } else {
      node.right = insert(node.right, val);
    }
    return node;
  }

  public static void inOrder(Node root) {
    if (root == null) {
      return;

    }
    inOrder(root.left);
    System.out.print(root.data + " ");
    inOrder(root.right);
  }

  public static Node delete(Node root, int val) {
    if (root == null) {
      return null;

    }
    if (root.data > val) {
      root.left = delete(root.left, val);
    } else if (root.data < val) {
      root.right = delete(root.right, val);
    } else {// root.data=val
      // case-1
      if (root.left == null && root.right == null) {
        return null;
      }
      // case-2
      if (root.left == null) {
        return root.right;
      }
      if (root.right == null) {
        return root.left;
      }
      // case-3
      Node is = inorderSuccessor(root.left);
      root.data = is.data;
      root.right = delete(root.right, is.data);

    }
    return root;

  }

  public static Node inorderSuccessor(Node root) {
    while (root.left != null) {
      root = root.left;
    }
    return root;

  }

  public static void main(String[] args) {
    int value[] = { 5, 1, 3, 4, 2, 7 };
    Node root = null;
    for (int i = 0; i < value.length; i++) {
      root = insert(root, value[i]);

    }
    inOrder(root);
    System.out.println();
    delete(root, 4);
    inOrder(root);

  }

}
