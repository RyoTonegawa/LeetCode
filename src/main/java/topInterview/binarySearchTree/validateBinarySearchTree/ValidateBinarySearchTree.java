package main.java.topInterview.binarySearchTree.validateBinarySearchTree;

public class ValidateBinarySearchTree {

  public boolean isValidBST(TreeNode root) {
    return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  /**
   * Validate whether given tree is BST or not.
   * To use this function recursively,
   * prepare max and min value.
   * -> when validate right node,
   * we only need to check right node is greater than root node.
   * Same as right node, we only need to check
   * left node and root node when validate left node.
   * 
   * @param node
   * @param minVal
   * @param maxVal
   * @return
   */
  public boolean validate(
      TreeNode node,
      long minVal,
      long maxVal) {
    if (node == null)
      return true;

    if (node.val <= minVal ||
        node.val >= maxVal) {
      return false;
    }
    return validate(
        node.left,
        minVal,
        node.val) &&
        validate(
            node.right,
            node.val,
            maxVal);
  }
}
