package main.java.topInterview.BinaryTreeGeneral;

public class SymmetricTree {
  public boolean isSymmetric(TreeNode root) {
    /*
     * base case
     */
    if(root == null){
      return true;
    }
    return isMirror(
      root.left,
      root.right
      );
  }
  //Helper funciton
  /**
   * check if the child nodes are symmetrical
   * @param left
   * @param right
   * @return
   */
  private boolean isMirror(
    TreeNode left,
    TreeNode right
  ){
    // Base cases
    if(left == null && right == null){
      return true;
    }
    /*
     * If either node is null,
     * return false because that means
     * its not symmetric.
     * And previous if statement
     * alerady checked the case
     * where both are null.
     */
    if(left == null || right == null){
      return false;
    }
    //Check if the current nodes have the
    // same value,
    // and recursively check child nodes
    // for symmetry
    return (left.val == right.val)
            && isMirror(left.left, right.right)
            && isMirror(left.right, right.left);
  }
}
