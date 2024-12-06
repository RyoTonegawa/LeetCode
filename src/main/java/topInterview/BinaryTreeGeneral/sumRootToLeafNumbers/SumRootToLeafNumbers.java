package main.java.topInterview.binaryTreeGeneral.sumRootToLeafNumbers;

public class SumRootToLeafNumbers {
  public int sumNumbers(TreeNode root) {
    return dfs(root, 0);
  }

  private int dfs(
      TreeNode node,
      int currentSum) {
    if (node == null) {
      return 0;
    }
    currentSum = currentSum * 10 + node.val;

    if (node.right == null &&
        node.left == null) {
      return currentSum;
    }

    return dfs(node.right, currentSum) + dfs(node.left, currentSum);
  }
}
