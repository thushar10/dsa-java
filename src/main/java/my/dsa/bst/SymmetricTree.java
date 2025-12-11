package my.dsa.bst;

public class SymmetricTree {

  public static void main(String[] args) {
    // Test Case 1: Balanced Tree
    //Integer[] balancedArray = {1, 2, 4, 3, null, 5, 6, 9, null, null, null, null, 7, null, null, null, 8};
    Integer[] balancedArray = {1, 2, 2, 4, 5, 5, 4, 6, 7, 8, 9, 9, 8, 7, 6};
    TreeNode balancedRoot = TreeNode.fromArray(balancedArray);

    SymmetricTree checker = new SymmetricTree();

    System.out.println("is the tree symmetric  " + checker.isSymmetric(balancedRoot));

  }

  private boolean isSymmetric(TreeNode root) {

    if(root == null) {
      return true;
    }

    return isMirror(root.left, root.right);

  }

  private boolean isMirror(TreeNode left, TreeNode right) {

    if(left == null && right == null) {
      return true;
    }

    if(left == null || right ==null || left.val != right.val ) {
      return false;
    }

    return isMirror(left.left, right.right) && isMirror(left.right, right.left);

  }
}
