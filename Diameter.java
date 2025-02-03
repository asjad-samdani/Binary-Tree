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

public class Diameter {
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

  public static int totalHeight(Node node) {
    if (node == null)
      return 0;
    return Math.max(totalHeight(node.left), totalHeight(node.right)) + 1;

  }

  // Time complexity(0(N^2));
  public static int diameter(Node node) {
    if (node == null)
      return 0;
    int dia1 = diameter(node.left);
    int dia2 = diameter(node.right);
    int dia3 = totalHeight(node.left) + totalHeight(node.right) + 1;
    return Math.max(dia1, Math.max(dia2, dia3));
  }

  // optimize approach-> Time Complexity(0(N))
  static class TreeInfo {
    int height;
    int diameter;

    public TreeInfo(int h, int d) {
      this.height = h;
      this.diameter = d;

    }
  }

  public static TreeInfo optDia(Node node) {
    if (node == null)
      return new TreeInfo(0, 0);

    TreeInfo left = optDia(node.left);
    TreeInfo right = optDia(node.right);
    int myHeight = Math.max(left.height, right.height) + 1;

    int diam1 = left.diameter;
    int dia2 = left.diameter;
    int dia3 = left.height + right.height + 1;
    int totalDiam = Math.max(diam1, Math.max(dia2, dia3));
    return new TreeInfo(myHeight, totalDiam);

  }

  public static void main(String[] args) {
    int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
    Node root = buildTree(nodes);
    System.out.println(optDia(root).diameter);
  }

}
