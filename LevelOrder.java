import java.util.LinkedList;
import java.util.Queue;

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

public class LevelOrder {
  static int idx = -1;

  public static Node buildTree(int[] node) {
    idx++;
    if (node[idx] == -1)
      return null;
    Node newNode = new Node(node[idx]);
    newNode.left = buildTree(node);
    newNode.right = buildTree(node);
    return newNode;
  }

  public static void inOrder(Node node) {
    if (node == null)
      return;
    Queue<Node> queue = new LinkedList<>();
    queue.add(node);
    queue.add(null);
    while (!queue.isEmpty()) {
      Node curr = queue.remove();
      if (curr == null) {
        System.out.println();
        if (queue.isEmpty())
          break;
        else
          queue.add(null);

      } else {
        System.out.print(curr.data + " ");
        if (curr.left != null)
          queue.add(curr.left);
        if (curr.right != null)
          queue.add(curr.right);

      }

    }

  }

  public static void main(String[] args) {
    int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
    Node root = buildTree(nodes);
    inOrder(root);

  }

}
