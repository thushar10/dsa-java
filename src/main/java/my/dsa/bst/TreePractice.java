package my.dsa.bst;

import com.sun.source.tree.Tree;

import java.util.*;

public class TreePractice {

  // --- 1. The TreeNode Class ---
  // A static nested class is easiest for testing in one file.
  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    // Constructor to create a new node
    TreeNode(int val) {
      this.val = val;
      this.left = null; // null by default, but good to be explicit
      this.right = null;
    }
  }

  // --- 2. The main() method to build and test ---
  public static void main(String[] args) {
    /*
     * Let's build this exact tree:
     *
     * 50
     * /  \
     * 40   70
     * /       /
     * 30    60
     */

    // Create the root
    TreeNode root = new TreeNode(50);

    // Create and attach the left subtree
    // We link them by assigning to the .left and .right properties
    root.left = new TreeNode(40);
    root.left.left = new TreeNode(30);

    // Create and attach the right subtree
    root.right = new TreeNode(70);
    root.right.left = new TreeNode(60);

    System.out.println("Tree built successfully. Root is: " + root.val);

    // --- Call your practice methods here ---
    TreePractice myTree = new TreePractice(); // Create an instance to call methods

    System.out.println("\n--- Testing Preorder ---");
    System.out.print("Your output:   ");
    myTree.preorder(root);
    System.out.println();
    myTree.preorderIterative(root);
    System.out.println("\nExpected output: 50, 40, 30, 70, 60");

    System.out.println("\n--- Testing Inorder ---");
    System.out.print("Your output:   ");
    myTree.inorder(root);
    System.out.println();
    myTree.inorderIterative(root);
    System.out.println("\nExpected output: 30, 40, 50, 60, 70");

    System.out.println("\n--- Testing Postorder ---");
    System.out.print("Your output:   ");
    myTree.postorder(root);
    System.out.println();
    myTree.postorderIterative(root);
    System.out.println("\nExpected output: 30, 40, 60, 70, 50");
  }

  // --- 3. Your Practice Zone ---
  // TODO: Fill in your recursive or iterative logic here!
  // (I've added print formatting to match the "Expected" output)

  /**
   * Rule: Visit -> Left -> Right
   */
  public void preorder(TreeNode node) {

    if(node == null) {
      return;
    }
    System.out.print(node.val+", ");
    if(node.left != null) preorder(node.left);
    if(node.right != null) preorder(node.right);

  }

  public void preorderIterative(TreeNode node) {

    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.push(node);

    while (!stack.isEmpty()) {

      TreeNode current = stack.pop();
      System.out.print(current.val+": ");

      if(current.right != null) stack.push(current.right);
      if(current.left != null) stack.push(current.left);

    }

  }


  /**
   * Rule: Left -> Visit -> Right
   */
  public void inorder(TreeNode node) {
    if(node == null) {
      return;
    }
    if(node.left != null) inorder(node.left);
    System.out.print(node.val+", ");
    if(node.right != null) inorder(node.right);


  }

  /**
   * Rule: Left -> Visit -> Right
   */
  public void inorderIterative(TreeNode node) {

    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode current = node;

    while(current != null || !stack.isEmpty()) {

      while (current != null) {
        stack.push(current);
        current = current.left;
      }
      current = stack.pop();
      System.out.print(current.val+": ");
      current = current.right;



    }


  }

  /**
   * Rule: Left -> Right -> Visit
   */
  public void postorder(TreeNode node) {

    if(node == null) {
      return;
    }
    if(node.left !=null) postorder(node.left);
    if(node.right !=null) postorder(node.right);
    System.out.print(node.val+", ");

  }


  /**
   * Rule: Left -> Right -> Visit
   */
  public void postorderIterative (TreeNode node) {

    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode lastViewed = null;

    TreeNode current = node;
    while (current != null || !stack.isEmpty()) {

      while (current != null) {
        stack.push(current);
        current = current.left;
      }

      TreeNode peek = stack.peek();

      if(peek.right != null && lastViewed != peek.right){
        current = peek.right;
      }else {
        System.out.print(peek.val+": ");
        lastViewed = stack.pop();
      }

    }
  }
  int globalMaxDiameter = 0;

  public int diameterOfBinaryTree(TreeNode root) {
    calculateHeight(root);
    return globalMaxDiameter;
  }

  private int calculateHeight(TreeNode node) {

    if(node == null) return 0;


    int leftHeight = calculateHeight(node.left);
    int rightHeight = calculateHeight(node.right);

    int currentDiameter = leftHeight + rightHeight;
    globalMaxDiameter = Math.max(currentDiameter, globalMaxDiameter);

    return 1 + Math.max(leftHeight, rightHeight);
  }

  private int calculateHeightOnly(TreeNode node) {

    if(node == null) return 0;


    int leftHeight = calculateHeight(node.left);
    int rightHeight = calculateHeight(node.right);


    return 1 + Math.max(leftHeight, rightHeight);
  }

}
