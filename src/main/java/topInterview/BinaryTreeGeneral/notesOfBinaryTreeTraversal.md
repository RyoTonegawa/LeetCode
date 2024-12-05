# About each traversal method of Binary Tree

## preorder traversal root -> left -> Right

Used to copy the tree or get a prefix notation of expressions.

## inorder Traversal Left -> right -> right

Used for binary search trees to retrieve elements in asceinding order

it loses order information?
why?

## postorder Traversal Left -> right -> root

Used to delete the tree or get a postfix notation of expressions

postfix notation is Reverse Polish Notation
this traversal is useful for stack-based evaluation.

cons
this traversal is complicate for cloning trees

Why inorder traversal is used to find k-th smallest elemnt?

## Real-Life Usage

- FileSystems
- Hierarchical Data Representation
  - Organizational Structures
  - Decision Tree
    - machine larning
    - artificial Interigence
- Network Routing Algorithms
- Heap Strctures
- Huffman Encoding

# Traversal Methods of Binary Trees: Usage, Pros, and Cons

| Traversal Type | Usage/Use Cases                           | Pros                                    | Cons                                      |
| -------------- | ----------------------------------------- | --------------------------------------- | ----------------------------------------- |
| **Preorder**   | Copy tree, prefix notation, serialization | Useful for tree reconstruction          | Not suitable for sorted output            |
| **Inorder**    | Retrieve BST elements in sorted order     | Results in sorted output for BSTs       | Cannot reconstruct the tree independently |
| **Postorder**  | Delete tree, postfix notation             | Ideal for resource cleanup, aggregation | Complex for cloning                       |

## Summary of Traversals

1. **Preorder Traversal** (Root -> Left -> Right):

   - **Usage**: Copying a tree, creating prefix notation.
   - **Pros**: Easy to reconstruct the tree, used for serialization.
   - **Cons**: Cannot produce elements in sorted order (BST).

2. **Inorder Traversal** (Left -> Root -> Right):

   - **Usage**: Retrieving BST nodes in ascending order.
   - **Pros**: Naturally provides sorted order for BSTs.
   - **Cons**: Does not retain full tree structure independently.

3. **Postorder Traversal** (Left -> Right -> Root):
   - **Usage**: Deleting a tree, creating postfix notation.
   - **Pros**: Well-suited for cleanup and post-processing tasks.
   - **Cons**: Complicated if you need to reconstruct or clone a tree.
