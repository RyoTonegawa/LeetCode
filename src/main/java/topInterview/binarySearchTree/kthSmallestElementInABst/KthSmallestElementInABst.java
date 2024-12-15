package main.java.topInterview.binarySearchTree.kthSmallestElementInABst;

public class KthSmallestElementInABst {
  private int count = 0;
  private int result = 0;

  public int kthSmallest(TreeNode root, int k) {
    inorderIterator(root, k);
    return result;
  }

  public void inorderIterator(TreeNode node, int k) {
    if (node == null) {
      return;
    }
    inorderIterator(node.left, k);
    this.count++;
    if (count == k) {
      result = node.val;
      return;
    }
    inorderIterator(node.right, k);
  }
}
