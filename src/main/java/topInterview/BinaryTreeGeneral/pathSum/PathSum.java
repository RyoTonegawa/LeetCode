package main.java.topInterview.binaryTreeGeneral.pathSum;

public class PathSum {
  public boolean hasPathSum(
      TreeNode root,
      int targetSum) {
    // Base case
    if (root == null) {
      return false;
    }

    /**
     * Check if we are at a leaf node
     * ad if the targetSum matches the
     * node's value
     */
    if (root.left == null &&
        root.right == null) {
      return targetSum == root.val;
    }
    /*
     * Minus root value from target
     * if we reach to the leaf node,
     * newTarget is same to the leaf node
     * value.
     */
    int newTarget = targetSum - root.val;

    /*
     * check child node values
     */
    return hasPathSum(root.left, newTarget) ||
        hasPathSum(root.right, newTarget);
  }
}
