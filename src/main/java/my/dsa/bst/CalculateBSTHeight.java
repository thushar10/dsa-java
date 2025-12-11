package my.dsa.bst;

import com.sun.source.tree.Tree;

public class CalculateBSTHeight {

  public static void main(String[] args) {
    // Test Case 1: Balanced Tree
    //Integer[] balancedArray = {1, 2, 4, 3, null, 5, 6, 9, null, null, null, null, 7, null, null, null, 8};
    Integer[] balancedArray = {1, 2, 3, null, null, 4, 5};
    TreeNode balancedRoot = TreeNode.fromArray(balancedArray);

    CalculateBSTHeight checker = new CalculateBSTHeight();

    System.out.println("Height of the tree is  " + checker.calculateHeight(balancedRoot));
    System.out.println("Is the tree balanced ? "+ checker.isBalanced(balancedRoot));

  }

  private boolean isBalanced(TreeNode node) {
    int i = calculateHeight(node);
    return i != -1;

  }

  private int calculateHeight(TreeNode node) {

    if(node == null) return 0;

    int leftHeight = calculateHeight(node.left);
    if(leftHeight == -1) return -1;
    int rightHeight = calculateHeight(node.right);
    if(rightHeight == -1) return -1;

    if (Math.abs(leftHeight - rightHeight) > 1) return -1;

    return 1 + Math.max(leftHeight, rightHeight);

  }
}
