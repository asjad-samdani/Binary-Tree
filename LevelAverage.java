import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

public class LevelAverage {
  public static Node buildTree(int[] node, int[] idx) {
    if (node[idx[0]] == -1)
      return null;
    Node newNode = new Node(node[idx[0]]);
    idx[0]++;
    newNode.left = buildTree(node, idx);
    idx[0]++;
    newNode.right = buildTree(node, idx);
    return newNode;
  }

  public static List<Double> averageOfLevels(Node node) {
    List<Double> result = new ArrayList<>();
    Queue<Node> queue = new LinkedList<>();
    queue.add(node);
    while (!queue.isEmpty()) {
      double size = queue.size();
      int levelSum = 0;
      for (int i = 0; i < size; i++) {
        Node curr = queue.remove();
        levelSum += curr.data;
        if (curr.left != null)
          queue.add(curr.left);
        if (curr.right != null)
          queue.add(curr.right);
      }
      result.add(levelSum / size);
    }
    return result;

  }

  public static void main(String[] args) {
    int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
    int[] idx = { 0 };
    Node root = buildTree(nodes, idx);
    System.out.println(averageOfLevels(root));

  }

}
