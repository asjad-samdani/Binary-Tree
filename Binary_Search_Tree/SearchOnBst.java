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

public class SearchOnBst {
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

  public static boolean search(Node root, int key) {
    if (root == null)
      return false;
    if (root.data > key) {// left subTree
      return search(root.left, key);
    } else if (root.data == key) {
      return true;
    } else {
      return search(root.right, key);

    }

  }

  public static void main(String[] args) {
    int value[] = { 5, 1, 3, 4, 2, 7 };
    Node root = null;
    for (int i = 0; i < value.length; i++) {
      root = insert(root, value[i]);

    }
    inOrder(root);
    System.out.println();
    if (search(root, 1)) {
      System.out.println("found");
    } else {
      System.out.println("Not found");
    }
  }

}
