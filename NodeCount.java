
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

public class NodeCount {
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

  public static int countOfNodes(Node node) {
    if (node == null)
      return 0;

    int leftCount = countOfNodes(node.left);
    int rightCount = countOfNodes(node.right);
    int totalCount = leftCount + rightCount + 1;
    return totalCount;

  }

  public static void main(String[] args) {
    int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
    Node root = buildTree(nodes);
    System.out.println(countOfNodes(root));
  }

}
