package my.dsa.bst;

import java.util.ArrayList;
import java.util.List;

public class PathSum1 {


  public static void main(String[] args) {
    // Test Case 1: Balanced Tree
    Integer[] balancedArray = {1, 2, 4, 3, null, 5, 6, 9, null, null, null, null, 7, null, null, null, 8};
    //Integer[] balancedArray = {1, 2, 3, null, null, 4, 5};
    TreeNode balancedRoot = TreeNode.fromArray(balancedArray);

    PathSum1 checker = new PathSum1();
    List<List<Integer>> globalPaths = new ArrayList<>();
    List<Integer> paths = new ArrayList<>();
    //System.out.println("path sum is there " + checker.hasPathSum(balancedRoot, 26, globalPaths, paths));
    checker.hasPathSum(balancedRoot, 26, globalPaths, paths);
    System.out.println(globalPaths);
  }


  private void hasPathSum(TreeNode node, int targetSum, List<List<Integer>> globalPaths, List<Integer> path) {
    if (node == null) return;

    path.add(node.val);
    if (node.left == null && node.right == null) {
      //return targetSum == node.val;
      if (targetSum == node.val) {
        globalPaths.add(new ArrayList<>(path));

      }

      path.remove(path.size() - 1);
      return;
    }

    int rem = targetSum - node.val;


    hasPathSum(node.left, rem, globalPaths, path);
    hasPathSum(node.right, rem, globalPaths, path);

    path.remove(path.size() - 1); // backtrack on the way up
  }


}
