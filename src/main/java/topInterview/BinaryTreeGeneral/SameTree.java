package main.java.topInterview.BinaryTreeGeneral;

import javax.swing.tree.TreeNode;

public class SameTree {
  //Recursive approach
  public boolean isSameTree(
    TreeNode p,
    TreeNode q
    ) {
    // Base case
    /*
     * If both nodes are null,
     * the trees are identical.
     */
    if(p == null && q == null){
      return true;
    }
    /*
     * If either p or q is null
     * the trees are not the same.
     * This is because the previous condition
     * already handledthe case
     * where both are null.
     */
    if(p == null || q == null){
      return false;
    }
    /*
     * If p and q have diffelent values,
     * that means they are not the same tree
     */
    if(p.val != q.val){
      return false;
    }
    /*
     * Recursively check the left and 
     * right subtrees
     */
    return isSameTree(p.left,q.left)&&
      isSameTree(p.right,q.right);
  }
}
