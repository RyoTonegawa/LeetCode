package main.java.topInterview.binaryTreeBFS.averageOfLevelsinBinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import main.java.topInterview.binaryTreeBFS.averageOfLevelsinBinaryTree.TreeNode;

class AverageOfLevelsInBinaryTree {
  public List<Double> averageOfLevels(
      TreeNode root) {
    // Base case
    if (root == null) {
      return new ArrayList<>();
    }
    List<Double> result = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      double levelSum = 0;
      for (int i = 0; i < levelSize; i++) {
        TreeNode current = queue.poll();

        levelSum += current.val;
        if (current.left != null) {
          queue.add(current.left);
        }
        if (current.right != null) {
          queue.add(current.right);
        }
      }
      result.add(levelSum / levelSize);
    }
    return result;
  }
}