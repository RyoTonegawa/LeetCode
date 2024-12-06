package main.java.topInterview.binaryTreeGeneral.fattenBinaryTree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

// Recursive Approach(Post-order Modification)
public class FattenBinaryTree {
  private TreeNode prev = null;

  public void flatten(TreeNode root) {
    // Handle Edgecase
    if (root == null) {
      return;
    }
    /*
     * Traverse right subtree first,
     * then left subtree
     */
    flatten(root.right);
    flatten(root.left);

    /*
     * Set the current node's right to
     * the previous node
     * 
     * Caution!
     * in this post-order approach,
     * previous node means the bigger number node
     */
    root.right = prev;//Move bigger number to the right
    root.left = null; //set null to the left
    prev = root;      //set next bigger number to root
  }
}
