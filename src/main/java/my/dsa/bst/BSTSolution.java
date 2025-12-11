package my.dsa.bst;

import java.awt.image.AffineTransformOp;
import java.util.*;

public class BSTSolution {

  public void main(String[] args) {
    BSTSolution bstSolution = new BSTSolution();

    bstSolution.levelOrder(new TreeNode(3));
  }


  public List<List<Integer>> levelOrder(TreeNode root) {

    Queue<TreeNode> queue = new LinkedList<>();
    List<List<Integer>> all = new ArrayList<>();
    queue.offer(root);

    if (root == null) {
      return all;  // handle empty tree
    }

    while (!queue.isEmpty()) {
      int levelSize = queue.size();

      List<Integer> currentLevelItems  = new ArrayList<>();

      for (int i =0; i< levelSize; i++) {
        TreeNode curr = queue.poll();
        currentLevelItems.add(curr.val);
        if(curr.left != null) queue.offer(curr.left);
        if(curr.right != null) queue.offer(curr.right);
      }
      all.add(currentLevelItems);
    }

    return all;
  }


  public List<Integer> preorderTraversal(TreeNode root) {

    List<Integer> result = new ArrayList<>();

    preOder(root, result);

    return result;
  }

  public List<Integer> inorderTraversal(TreeNode root) {

    List<Integer> result = new ArrayList<>();


    inOder(root, result);

    return result;
  }


  public List<Integer> preorderTraversalIterative(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) return result;

    Deque<TreeNode> stack = new ArrayDeque<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      TreeNode node = stack.pop();
      result.add(node.val);            // visit root now (preorder)

      if (node.right != null) stack.push(node.right); // push right first
      if (node.left != null)  stack.push(node.left);  // then left, so it’s processed first
    }
    return result;
  }

  public void preOder(TreeNode node , List<Integer> result) {
    if(node == null) return;
    result.add(node.val);
    if(node.left != null) preOder(node.left, result);
    if(node.right != null) preOder(node.right, result);

  }


  public void inOder(TreeNode node , List<Integer> result) {
    if(node == null) return;
    if(node.left != null) inOder(node.left, result);
    result.add(node.val);
    if(node.right != null) inOder(node.right, result);
  }

  public void postOder(TreeNode node , List<Integer> result) {
    if(node == null) return;
    if(node.left != null) postOder(node.left, result);
    if(node.right != null) postOder(node.right, result);
    result.add(node.val);
  }


  // Definition for a binary tree node.
  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }

  }
}
