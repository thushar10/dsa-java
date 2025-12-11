package my.dsa.bst;

public class LCABinaryTree {


  public static void main(String[] args) {
    // Build the tree from your level-order array
    Integer[] balancedArray = {
      1, 2, 4, 3, null, 5, 6, 9, null, null, null, null, 7, null, null, null, 8
    };
    TreeNode balancedRoot = TreeNode.fromArray(balancedArray);

    // Find p and q *inside* the tree, by value
    TreeNode p = findNode(balancedRoot, 5);  // change values to test different pairs
    TreeNode q = findNode(balancedRoot, 6);

    if (p == null || q == null) {
      System.out.println("One of the nodes was not found in the tree.");
      return;
    }

    LCABinaryTree sol = new LCABinaryTree();
    TreeNode lca = sol.lca(balancedRoot, p, q);

    System.out.println("p = " + p.val + ", q = " + q.val);
    System.out.println("LCA value = " + (lca != null ? lca.val : "null"));
  }

  private TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
    if(root == null) {
      return null;
    }
    if(root == p || root == q) {
      return root;
    }

    TreeNode leftLCA = lca(root.left, p, q);
    TreeNode rightLCA = lca(root.right, p, q);

    if(leftLCA != null && rightLCA != null)
      return root;

    return leftLCA !=null ? leftLCA : rightLCA;


  }
  // Simple DFS helper to get the actual node reference by value
  private static TreeNode findNode(TreeNode root, int target) {
    if (root == null) return null;
    if (root.val == target) return root;

    TreeNode left = findNode(root.left, target);
    if (left != null) return left;

    return findNode(root.right, target);
  }

}
