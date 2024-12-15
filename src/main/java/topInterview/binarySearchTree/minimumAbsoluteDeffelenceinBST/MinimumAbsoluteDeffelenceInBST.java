package main.java.topInterview.binarySearchTree.minimumAbsoluteDeffelenceinBST;

import java.util.ArrayList;
import java.util.List;

public class MinimumAbsoluteDeffelenceInBST {
  public int getMinimumDefference(
      TreeNode root) {
    List<Integer> inorderValues = new ArrayList<>();

    inorderTraversal(root, inorderValues);

    int minDiff = Integer.MAX_VALUE;
    for (int i = 1; i < inorderValues.size(); i++) {
      int diff = inorderValues.get(i) - inorderValues.get(i - 1);
      if (diff < minDiff) {
        minDiff = diff;
      }
    }
    return minDiff;
  }

  private void inorderTraversal(
      TreeNode node,
      List<Integer> list) {
    if (node == null)
      return;
    inorderTraversal(node.left, list);
    list.add(node.val);
    inorderTraversal(node.right, list);
  }
}
