package main.java.topInterview.binaryTreeGeneral.bstIterator;

import java.util.Stack;

/**
 * 
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 * 
 * Step-by-Step explanation
 * After the initialization,
 * stack contains [7,3].
 * 
 * On the first next() call .
 * . 3 is popped from the stack
 * . Since 3 has no right child, nothing more is added to the stack.
 * 
 * On the second next() call.
 * . 7 is popped from the stack.
 * . The right child of 7(15) is passed topushLeftNodes()
 * . Then, 15 and its left child (9) is pushed onto the stack in the loop.
 * 
 * On the 3rd next() call
 * . 9 is popped from the stack
 * . Same as 1st next() call, 9 has no right nodes.
 * 
 * On the 4th next() call
 * . 15 is popped from the stack
 * . The right child of 15(20) is passed to the pushLeftNodes()
 * . Inside the loop, 20 is pushed to the stack
 * 
 * And finally 20 is popped from the stack!
 * 
 */

// BST = Binary Search Tree(In-order traversal)
public class BstIterator {
  // manage nodes while performing an in-order traversal
  private Stack<TreeNode> stack;

  private void pushLeftNodes(TreeNode node) {
    /*
     * This loop ensures that the
     * leftmost node is on the top
     * of the stack
     */
    while (node != null) {
      stack.push(node);
      node = node.left;
    }
  }

  // O(h) complexity : h= height of the tree
  public BSTIterator(TreeNode root) {
    stack = new Stack<>();
    pushLeftNodes(root);
  }

  public int next() {
    TreeNode currentNode = stack.pop();
    if (currentNode.right != null) {
      pushLeftNodes(currentNode.right);
    }
    return currentNode.val;
  }

  public boolean hasNext() {
    return !stack.isEmpty();
  }
}
