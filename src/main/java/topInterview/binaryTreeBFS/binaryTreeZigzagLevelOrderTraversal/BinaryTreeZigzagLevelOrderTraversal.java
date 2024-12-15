package main.java.topInterview.binaryTreeBFS.binaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Why using BFS instead of DFS?
 * Because BFS is usually more straightforward for level order problems.
 */
public class BinaryTreeZigzagLevelOrderTraversal {
  public List<List<Integer>> zigzaglevelOrder(
      TreeNode root) {
    // Typical BFS Code
    List<List<Integer>> result = new ArrayList<>();
    if (root == null)
      return result;

    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    int level = 0;

    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      List<Integer> currentLevel = new ArrayList<>(levelSize);

      for (int i = 0; i < levelSize; i++) {
        TreeNode current = queue.poll();
        currentLevel.add(current.val);

        if (current.left != null) {
          queue.offer(current.left);
        }
        if (current.right != null) {
          queue.offer(current.right);
        }
      }
      /**
       * Point
       * If the level is odd, reverse the current level values
       */
      if (level % 2 == 1) {
        Collections.reverse(currentLevel);
      }

      result.add(currentLevel);
      level++;
    }

    return result;
  }
}
