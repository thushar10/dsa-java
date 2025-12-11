package my.dsa.bst;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {


  public static void main(String[] args) {
    // Test Case 1: Balanced Tree
    Integer[] balancedArray = {1, 2, 4, 3, null, 5, 6, 9, null, null, null, null, 7, null, null, null, 8};
    //Integer[] balancedArray = {1, 2, 3, null, null, 4, 5};
    TreeNode balancedRoot = TreeNode.fromArray(balancedArray);

    BoundaryTraversal checker = new BoundaryTraversal();

    System.out.println("boundary is " + checker.boundaryTraversal(balancedRoot));

  }

  private List<Integer> boundaryTraversal(TreeNode balancedRoot) {
    List<Integer> result = new ArrayList<>();

    reachLeft(balancedRoot, result);
    getLeaf(balancedRoot, result);
    reachRight(balancedRoot, result);

    return result;

  }

  private void getLeaf(TreeNode node, List<Integer> leafNodes) {

    if(node == null) return;

    if(node.left == null && node.right == null) {
      leafNodes.add(node.val);
    }

    getLeaf(node.left, leafNodes);
    getLeaf(node.right, leafNodes);

  }

  private void reachLeft(TreeNode node, List<Integer> result) {
    if(node == null || (node.left == null && node.right == null)) return;
    result.add(node.val);

    if(node.left != null) {
      reachLeft(node.left, result);
    }else {
      reachLeft(node.right, result);
    }
  }

  private void reachRight(TreeNode node, List<Integer> result) {
    if(node == null || (node.left == null && node.right == null)) return;


    if(node.right != null) {
      reachRight(node.right, result);
    }else {
      reachRight(node.left, result);
    }
    result.add(node.val);
  }
}
