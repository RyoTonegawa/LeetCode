package main.java.topInterview.binaryTreeBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import main.java.topInterview.binaryTreeBFS.TreeNode;

/**
 * My first consideration.
 * 
 * we need to declare two things.
 * 1.private Local variable ArrayList
 * to keep nodes of right side view.
 * 2.recursive called function.
 * This function traverse BinaryTree nodes
 * and keep track depth of each node.
 * 
 * traverse tree from right-most side
 * to left side
 * 
 * At first,
 * keep right-most routes node values
 * to ArrayList.
 * 
 * Then from second root
 * check deepest node index and
 * if deeper node found,
 * add node value to array.
 * 
 * After the iteration,
 * ArrayList keeps the Right Side View
 * ///////////////////////////////
 * 
 * Above algorithm is efficient for
 * small height trees.
 * If the tree is large height and width,
 * BFS is more efficient algorithm.
 * 
 */

/**
 * But this is a problem for BFS apploach.
 * So, I'll try BFS apploach
 */
public class BInaryTreeRightSideView {
  public List<Integer> rightSideView(
      TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) {
      return result;
    }

    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int levelSize = queue.size();
      for (int i = 0; i < levelSize; i++) {
        TreeNode current = queue.poll();
        if (i == levelSize - 1) {
          result.add(current.val);
        }

        if (current.left != null) {
          queue.add(current.left);
        }
        if (current.right != null) {
          queue.add(current.right);
        }
      }
    }
    return result;
  }
}
