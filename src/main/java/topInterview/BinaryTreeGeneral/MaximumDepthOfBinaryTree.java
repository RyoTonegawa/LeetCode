
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * Definition for a binary tree node.
 public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/**
 * Recursive solution
 */
class MaximamDepthOfBinaryTree {

  public int recursiveSolution(TreeNode root) {
      if(root == null){
        // Base case empty tree has depth 0
        /*
         * What is the base case?
         * Is it different from edge case?
         */
        return 0;
      }
      /*
       * recursively find depth of
       * left and right depth
       */
      int leftDepth = maxDepth(root.right);
      int rightDepth = maxDepth(root.right);

      return 1 + Math.max(leftDepth,rightDepth);
  }
  /*
   * Use a queue to perform a level-order traversal
   * At a each level, count the nodes and invrement the depth counter
   * Question: What is the BFS?
   * Answer Breadth-First Serch.
   * BFS is an algorithm ued to traversa or search a tree
   * or graph
   * 
   */
  public int iterativeSolution(TreeNode root){
    // Base case
    if(root ==null){
      return 0;
    }
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    int depth = 0;

    while(!queue.isEmpty()){
      int size = queue.size();
      for(int i = 0; i<size;i++){
        TreeNode node = queue.poll();
        // Add children to the queue
        if(node.left != null) queue.add(node.left);
        if(node.right != null) queue.add(node.right);

      }
      // Increment depth after processing each level
      depth++;
    }
    return depth;
  }
}