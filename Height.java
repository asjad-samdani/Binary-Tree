import java.util.LinkedList;
import java.util.Queue;

class Node {
  int data;
  Node left, right;

  public Node(int data) {
    this.data = data;
    this.left = null;
    this.right = null;
  }
}

public class Height {
  static int idx = -1;

  public static Node buildTree(int[] node) {
    idx++;
    if (idx >= node.length || node[idx] == -1)
      return null;
    Node newNode = new Node(node[idx]);
    newNode.left = buildTree(node);
    newNode.right = buildTree(node);
    return newNode;
  }

  public static int totalHeight(Node node) {
    if (node == null)
      return 0;

    Queue<Node> queue = new LinkedList<>();
    queue.add(node);
    int numberOfLevels = -1;

    while (!queue.isEmpty()) {
      int nodeCountAtLevel = queue.size();
      numberOfLevels++; // Increment level at each iteration of outer loop

      while (nodeCountAtLevel > 0) {
        Node element = queue.poll();
        if (element.left != null)
          queue.add(element.left);
        if (element.right != null)
          queue.add(element.right);
        nodeCountAtLevel--;
      }
    }

    return numberOfLevels;
  }

  public static void main(String[] args) {
    int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
    idx = -1; // Reset index before building tree
    Node root = buildTree(nodes);
    System.out.println("Height of the tree: " + totalHeight(root));
  }
}
