import java.util.HashMap;

public class ConstructBinaryTree {
  public TreeNode buildTree(int[] preorder, int[] inorder) {
    // Map to store the index of each value in inorder array for quick lookup
    HashMap<Integer, Integer> inorderIndexMap = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      inorderIndexMap.put(inorder[i], i);
    }
    // Call the helper function to construct the tree
    return buildTreeHelper(
        preorder,
        0,
        preorder.length - 1,
        inorder,
        0,
        inorder.length - 1,
        inorderIndexMap);
  }

  private TreeNode buildTreeHelper(
      int[] preorder,
      int preStart,
      int preEnd,
      int[] inorder,
      int inStart,
      int inEnd,
      HashMap<Integer, Integer> inorderIndexMap) {
    // Base case: if there are no elements to construct the tree
    if (preStart > preEnd || inStart > inEnd) {
      return null;
    }

    // The first element in preorder is the root of the current subtree
    /*
     * First iteration,
     * preorder :[3,9,20,15,7]
     * inorder: [9,3,15,20,7]
     * rootValue = 3
     * 
     */
    int rootValue = preorder[preStart];
    TreeNode root = new TreeNode(rootValue);
    /*
     * First iteration
     * inorderIndexMap.get(rootValue) returns 1,
     * Thenleft SubTreeSize = 1(1-0)
     * This means only 9 is the left subtree node.
     * And from this logic,
     * we can realize root(the first element of the preorder)
     * sapalates left and right sub trees.
     * [3, 9(root),20,15,7]
     */
    // Find the index of the root in the inorder array
    int rootIndexInorder = inorderIndexMap.get(rootValue);
    int leftSubtreeSize = rootIndexInorder - inStart;

    // Recursively build the left and right subtrees
    /*
     * First iteration
     * 1 preStart: root+1
     * 2 0 + 1
     * inEnd : 2 - 1
     */
    root.left = buildTreeHelper(
        preorder,
        preStart + 1, // second element is the left side tree root
        preStart + leftSubtreeSize, //
        inorder,
        inStart,
        // [9,3,15,20,7] rootIndexInorder is 3(index 1)
        rootIndexInorder - 1, // left subtree ends in former element of root
        inorderIndexMap);

    root.right = buildTreeHelper(
        preorder,
        // preorder array lines [leftNodes,root,rightNodes]
        // so, 1 means root. By adding leftSubTreeSize,
        // we can start from next tree nodes.
        preStart + leftSubtreeSize + 1,
        preEnd,
        inorder,
        // the start of the right sub tree is next of the rootIndexInorder
        rootIndexInorder + 1,
        inEnd, // the end of the right subtree is always inEnd
        inorderIndexMap);

    return root;
  }
}
