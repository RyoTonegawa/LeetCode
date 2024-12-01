package main.java.topInterview.BinaryTreeGeneral;

import javax.swing.tree.TreeNode;


public class InvertBinaryTree {
  public TreeNode invertTree(TreeNode root) {
        // base case
        if(root == null){
          return null;
        }
        // Switch nodes
        TreeNode tempNode = root.right;
        root.right = root.left;
        root.left = tempNode;

        // check depper nodes
        invertTree(root.right);
        invertTree(root.left);

        return root;
  }
}
