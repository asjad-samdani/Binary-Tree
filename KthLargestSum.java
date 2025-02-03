
import java.util.LinkedList;
import java.util.PriorityQueue;
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

public class KthLargestSum {
  static int idx;

  public static Node buildTree(int[] node) {
    idx++;
    if (node[idx] == -1)
      return null;
    Node newNode = new Node(node[idx]);
    newNode.left = buildTree(node);
    newNode.right = buildTree(node);
    return newNode;
  }

  public static int kthNodeSum(Node node, int k) {
    if (node == null)
      return -1;
    Queue<Node> queue = new LinkedList<>();
    queue.add(node);
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    while (!queue.isEmpty()) {
      int size = queue.size();
      int levelSum = 0;

      for (int i = 0; i < size; i++) {
        Node curr = queue.remove();
        levelSum += curr.data;
        if (curr.left != null)
          queue.add(curr.left);
        if (curr.right != null)
          queue.add(curr.right);
      }
      pq.add(levelSum);
      if (pq.size() > k) {
        pq.poll();

      }

    }
    return pq.size() == k ? pq.poll() : -1;

  }

  public static void main(String[] args) {
    int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
    idx = -1;
    Node root = buildTree(nodes);
    System.out.println(kthNodeSum(root, 1));

  }

}
