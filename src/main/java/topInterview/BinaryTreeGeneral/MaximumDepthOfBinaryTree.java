
import java.util.LinkedList;
import java.util.Queue;
import main.java.topInterview.BinaryTreeGeneral.TreeNode;

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
 * Breadth-First Search versus Depth-First Search
 * 
 * Time Complexity
 * Both BFS and DFS generally have the same
 * time complexity O(V+E).
 * V is number of nodes(vertices) and E is
 * number of edges.
 * 
 * Space Complexity
 * -BFS keeps queue to keep track of nodes
 * to be explored.
 * Especially in wide or deep graph,it grows
 * quite large. This make BFS more memory-intensive
 * 
 * DFS's time complexity depends on the 
 * depth of the graph.
 * It used a stack iternallu to keep track of the
 * current path being explored.
 * This characteristic can cause DFS to run
 * into stack overflow when the graph is 
 * very deep.
 * 
 * Summary
 * BFS is efficient 
 * 1.When find shortest path
 * 2.Where the target
 * is close to the root.
 * 
 * DFS is efficient when
 * 1.problems that requires exploring depp paths
 * 2.scenarios where memory is constrained
 * 3.need to explore all potential paths
 *  e.g. backtracking or findng connected components like linkedList
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
   * or graph.
   * It's usefull for finding the shortest path in
   * unweighted graphs or exploring nodes level 
   * by level.
   * 
   * BFS used a queue data structure.
   * its FIFO
   * to keep trach of nodes to be explored.
   * this algorithm starts at a specified node(root)
   * and explores all
   * neighboring nodes before moving to the next
   * level of nodes.
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