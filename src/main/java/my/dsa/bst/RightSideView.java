package my.dsa.bst;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class RightSideView {



  public static void main(String[] args) {
    // Test Case 1: Balanced Tree
    Integer[] balancedArray = {1, 2, 4, 3, null, 5, 6, 9, null, null, null, null, 7, null, null, null, 8};
    //Integer[] balancedArray = {1, 2, 3, null, null, 4, 5};
    TreeNode balancedRoot = TreeNode.fromArray(balancedArray);

    RightSideView checker = new RightSideView();

    System.out.println("Right side view of the tree is  " + checker.rightSide(balancedRoot));

  }

  private List<Integer> rightSide(TreeNode root) {

    if(root == null) {
      return null;
    }
    List<Integer> view = new ArrayList<>();
    Deque<TreeNode> queue = new LinkedList<>();

    queue.offer(root);

    while (!queue.isEmpty()) {

      int levelSize = queue.size();


      for (int i = 0; i < levelSize; i++) {

        TreeNode current = queue.poll();

        if(current.left != null) queue.offer(current.left);
        if(current.right != null) queue.offer(current.right);


        if(i == levelSize-1) {
          view.add(current.val);
        }
      }

    }


    return view;
  }


}
