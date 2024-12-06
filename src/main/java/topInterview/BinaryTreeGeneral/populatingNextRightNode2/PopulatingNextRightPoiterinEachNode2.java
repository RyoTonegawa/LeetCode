package main.java.topInterview.BinaryTreeGeneral;

/*
 * Given a binary tree
 * 
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no
 * next right node, the next pointer should be set to NULL.
 * 
 * Initially, all next pointers are set to NULL.
 */
public class PopulatingNextRightPoiterinEachNode2 {
  public Node connect(Node root) {
    /*
     * Apploach
     * To solve this ploblem,
     * using a breath-first-search and queue is the efficient way.
     * 
     * Step 1 Level-Order Traversal
     * Step 2 Use of a Dummy Node
     */

    if (root == null) {
      return null;
    }
    // Start with the root node
    Node current = root;

    /*
     * Dummy node that helps to track
     * the start of the next level
     * 
     * Dummy head is the placeholder
     */
    Node dummyHead = new Node(0);
    Node prev = dummyHead;

    while (current != null) {
      // traverse the current level
      while (current != null) {
        if (current.next != null) {
          prev.next = current.left;
          /*
           * In the first iteration,
           * now dummy head points left Node
           * by above line manipulation.
           */
          prev = prev.next;
        }
        if (current.right != null) {
          prev.next = current.right;
          prev = prev.next;
        }
        /*
         * Move to the next node
         * in the current level
         */

        /**
         * In the second level,
         * current.next is becomes null.
         * so, break nested while loop
         */
        current = current.next;
      }
      // Move to next level
      current = dummyHead.next;
      // Reset the dummy node for the next level
      /*
       * Because in the inner loop,
       * we set the most left side node
       * of the next level to the prev.next
       */
      dummyHead.next = null;
      // Reset prev to the dummy node
      prev = dummyHead;
      /*
       * After the first iteration,
       * dummyhead points to the root node
       * current points to the 2
       * -> setted by current in the inner while loop
       */
    }
    return root;
  }
}
