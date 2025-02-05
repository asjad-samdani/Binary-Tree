import java.util.Collections;
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

public class MaximumBinaryTree {
  public static Node constructMaximumBinaryTree(int[] nums) {
    if (nums == null)
      return null;
    return build(nums, 0, nums.length - 1);
  }

  public static Node build(int[] nums, int start, int end) {
    if (start > end)
      return null;
    int idxMax = start;
    for (int i = start + 1; i <= end; i++) {
      if (nums[i] > nums[idxMax])
        idxMax = i;
    }
    Node root = new Node(nums[idxMax]);
    root.left = build(nums, start, idxMax - 1);
    root.right = build(nums, idxMax + 1, end);
    return root;
  }

  public static List<String> levelOrder(Node node) {
    if (node == null)
      return Collections.emptyList();
    List<String> result = new LinkedList<>();
    Queue<Node> queue = new LinkedList<>();
    queue.add(node);
    while (!queue.isEmpty()) {
      Node root = queue.remove();
      if (root != null) {
        result.add(String.valueOf(root.data)); // FIXED: Correctly adding current node's data
        queue.add(root.left);
        queue.add(root.right);
      } else {
        result.add("null");
      }
    }

    // Remove trailing "null" values from the list
    while (!result.isEmpty() && result.get(result.size() - 1).equals("null")) {
      result.remove(result.size() - 1);
    }
    return result;
  }

  public static void main(String[] args) {
    int node[] = { 3, 2, 1, 6, 0, 5 };
    Node root = constructMaximumBinaryTree(node);
    System.out.println();
    System.out.println("Root of the Maximum Binary Tree: " + root.data);
    System.out.println("Level Order Representation: " + levelOrder(root));
  }
}
