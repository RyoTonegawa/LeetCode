package main.java.topInterview.binaryTreeGeneral.lowestCommonAncestorOfABinaryTree;

/**
 * ancestor = 祖先
 * 236. Lowest Common Ancestor of a Binary Tree
 * Medium
 * 
 * Topics
 * Companies
 * Given a binary tree, find the lowest common ancestor (LCA) of
 * two given nodes
 * in the tree.
 * 
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor
 * is defined between two nodes p and q as the lowest node in
 * T that has both p
 * and q as descendants
 * (where we allow a node to be a descendant of itself).”
 */

/**
 *   Sample Tree
     3
    / \
   5   1
  / \ / \
 6  2 0  8
   / \
  7   4
 */

/**
 * Key Idea
 * LCA is the deepest node that has
 * p and q as descendants.
 * 
 * In other words, the first node
 * which fill the condition
 * `left != null && right != null`
 * is the LCA
 */
public class LowestCommonAncestorOfABinaryTree {
  public TreeNode lowestCommonAncestor(
      TreeNode root,
      TreeNode p,
      TreeNode q) {
    // base case
    if (root == null ||
        root == p ||
        root == q) {
      return root;
    }
    TreeNode left = lowestCommonAncestor(root.left, p, q);
    TreeNode right = lowestCommonAncestor(root.right, p, q);

    /**
     * if following condition works,
     * when root is lowest ancestor,
     * left and right is not null.
     * And if left and right is not null,
     * the root is ancestor.
     * This is the another way of expressing the key idea
     */
    if (left != null && right != null) {
      // LCA found !
      return root;
    }
    // Edge node or a node lacking either its left or right subtree
    return (left != null) ? left : right;

  }
}
