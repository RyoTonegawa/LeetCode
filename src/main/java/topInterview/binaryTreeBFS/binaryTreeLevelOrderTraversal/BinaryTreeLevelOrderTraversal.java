package main.java.topInterview.binaryTreeBFS.binaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
  public List<List<Integer>> levelOrder(
      TreeNode root) {
    // BaseCase
    if (root == null) {
      return new ArrayList<>();
    }
    List<List<Integer>> result = new ArrayList<>();
    // declare Queue to traverse BinaryTree
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      List<Integer> eachLevelNodes = new ArrayList();

      for (int i = 0; i < levelSize; i++) {
        TreeNode current = queue.poll();
        eachLevelNodes.add(current.val);

        if (current.left != null) {
          queue.add(current.left);
        }

        if (current.right != null) {
          queue.add(current.right);
        }
      }
      result.add(eachLevelNodes);
    }
    return result;
  }
}
