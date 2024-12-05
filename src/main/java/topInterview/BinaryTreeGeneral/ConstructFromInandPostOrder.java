package main.java.topInterview.BinaryTreeGeneral;

import java.util.HashMap;

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
/**
 * postorder
 * 4 8 9 5 2 6 10 7 3 1
 * Inorder
 * 4 2 8 5 9 1 6 3 10 7
 */
public class ConstructFromInandPostOrder {
  public TreeNode buildTree(
      int[] inorder,
      int[] postorder) {
    /*
     * create a map to store the index of each value
     * inorder array for quick lookup
     */
    HashMap<Integer, Integer> inorderIndexMap = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      inorderIndexMap.put(inorder[i], i);
    }
    return buildTreeHelper(
        inorder,
        0,
        inorder.length - 1,
        postorder,
        0,
        postorder.length - 1,
        inorderIndexMap);
  }

  private TreeNode buildTreeHelper(
      int[] inorder,
      int inStart,
      int inEnd,
      int[] postorder,
      int postStart,
      int postEnd,
      HashMap<Integer, Integer> inorderIndexMap) {
    /*
     * base case
     * if there are no elements to construct the subtree
     * ! Check here to understand this problem
     * why this condition works?
     */
    if (inStart > inEnd || postStart > postEnd) {
      return null;
    }
    // the last element in postorder is the root of the current subtree
    int rootValue = postorder[postEnd];
    TreeNode root = new TreeNode(rootValue);

    /**
     * Find the index of the root in
     * the inorder array
     */
    int rootIndexInorder = inorderIndexMap.get(rootValue);
    int leftSubtreeSize = rootIndexInorder - inStart;
    /**
     * second iteration
     * right tree
     * 
     * inorder 4 2 8 5 9 1 6 3 10 7
     * 0
     * 4 ( 5 - 1 )
     * postorder 4 8 9 5 2 6 10 7 3 1
     * 0
     * 4 (0 + 5 - 1)
     */
    root.left = buildTreeHelper(
        inorder,
        inStart,
        rootIndexInorder - 1,
        postorder,
        postStart,
        postStart + leftSubtreeSize - 1,
        inorderIndexMap);
    /**
     * second iteration
     * right tree
     * 
     * inorder 4 2 8 5 9 1 6 3 10 7
     * 6 (idx5 + 1 )
     * 8 (length - 1)
     * postorder 4 8 9 5 2 6 10 7 3 1
     * 5
     * 8 (length -1 and one more minus 1)
     */
    root.right = buildTreeHelper(
        inorder,
        rootIndexInorder + 1,
        inEnd,
        postorder,
        postStart + leftSubtreeSize,
        postEnd - 1,
        inorderIndexMap);
    return root;
  }
}
