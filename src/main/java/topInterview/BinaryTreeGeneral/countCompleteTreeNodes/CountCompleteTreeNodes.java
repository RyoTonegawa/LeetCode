package main.java.topInterview.binaryTreeGeneral.countCompleteTreeNodes;

/**
 * To solve this problem efficiently,
 * we can leverage the properties of a
 * complete binary tree.
 * 
 * Complete Binary Tree Properties
 * 1. Every level except possibly the last is completely filled
 * 2. Nodes on the last level are as far left as possible
 * 3. A complete binary tree of height h can have between 2^h and
 * 2^(h+1) -1 nodes
 */
/**
 * Steps of algorithm
 * 1. Calculate the Tree depth
 * 2. Binary Search on the last level
 * 3. Combine Counts
 */

/**
 * Complexities
 * Overall complexity is O(h^2), where h is the height of the tree.
 */

public class CountCompleteTreeNodes {
  public int countNodes(TreeNode root) {
    // Handle edge case
    if (root == null) {
      return 0;
    }

    int depth = calculateDepth(root);

    if (depth == 0) {
      return 1;
    }

    /*
     * Step 3
     * Perform binary search to count nodes
     * in the last level
     */
    int left = 0, right = (int) Math.pow(2, depth) - 1;
    /**
     * While narrowing the range between
     * right and left , the while loop
     * continues until left and right either
     * meet or the range becomes invalid.
     */
    while (left <= right) {
      /**
       * Q: Why is this formula preferred?
       * A: To avoid integer overflow.
       * When left and right are very large,
       * (left + right) / 2 can lead to overflow.
       */
      int mid = left + (right - left) / 2;
      if (nodeExists(mid, depth, root)) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }

    // Step 4 Calculate the total number of nodes
    /**
     * Math.pow(2,depth) calculates the total number of nodes
     * above the last level.
     * And the left represents the number
     * of nodes in the last level.
     */
    return (int) Math.pow(2, depth) - 1 + left;
  }

  /**
   * Check depth of the tree
   * Leverage the property of the
   * complete binary tree.
   * 
   * @param node
   * @return
   */
  private int calculateDepth(TreeNode node) {
    int depth = 0;
    while (node.left != null) {
      depth++;
      node = node.left;
    }
    return depth;
  }

  /**
   * Check if a node at the given index exists in the last level
   * 
   * @param index
   * @param depth
   * @param node
   * @return
   */
  private boolean nodeExists(
      int index,
      int depth,
      TreeNode node) {
    /**
     * In level 2,
     * index of the rightmost node is 3.
     * 2^2-1 is 3
     */
    int left = 0, right = (int) Math.pow(2, depth) - 1;
    for (int i = 0; i < depth; i++) {
      // mid stands for the middle index
      int mid = left + (right - left) / 2;
      /**
       * notes
       * at the second iteration,
       * mid = 2 (2 + ( 3 - 2 ) / 2 = 2)
       */
      if (index <= mid) {
        node = node.left;
        right = mid;
      } else {
        node = node.right;
        left = mid + 1;
      }
    }
    return node != null;
  }
}
