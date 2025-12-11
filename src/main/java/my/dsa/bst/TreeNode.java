package my.dsa.bst;

import java.util.LinkedList;
import java.util.Queue;

// The standard TreeNode class used in LeetCode problems
public class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  // Constructors
  public TreeNode() {}
  public TreeNode(int val) { this.val = val; }
  public TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

  /**
   * A static utility method to build a binary tree from a level-order array.
   * Use 'null' in the array to represent a missing node.
   * * @param values An array of Integer where null represents a missing child.
   * @return The root of the constructed binary tree.
   */
  public static TreeNode fromArray(Integer[] values) {
    if (values == null || values.length == 0 || values[0] == null) {
      return null;
    }

    // The first element is always the root
    TreeNode root = new TreeNode(values[0]);
    // Queue to hold nodes whose children are yet to be assigned
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    int i = 1; // Start processing array elements from the second one (index 1)

    while (!queue.isEmpty() && i < values.length) {
      TreeNode current = queue.poll();

      // --- Process Left Child ---
      Integer leftVal = values[i++];
      if (leftVal != null) {
        current.left = new TreeNode(leftVal);
        queue.add(current.left);
      }

      // Check if we've run out of elements
      if (i >= values.length) {
        break;
      }

      // --- Process Right Child ---
      Integer rightVal = values[i++];
      if (rightVal != null) {
        current.right = new TreeNode(rightVal);
        queue.add(current.right);
      }
    }

    return root;
  }
}
