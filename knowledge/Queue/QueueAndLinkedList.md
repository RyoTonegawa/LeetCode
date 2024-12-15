## What is a LinkedList?

A LinkedList is a linear data structure
that consists of nodes where each node contains two parts

1. Data: the value of data the nodes stores
2. Next: A refelence to the next node in the list.
   If it's the last node, this refelence is null.

### Sample implementation

```java
class Node {
  int data;
  Node next;
  Node(int data){
    this.data = data;
    this.next = null;
  }
}

class LinkedList {
  Node head;
  public LinkedList(){
    this.head = null;
  };
  /**
   * Another operations like
   * insert, delete, traverse
   * would go here.
   */
}
```

## What is a Queue?

Queue is a linear data structure that
follows the First-In-First-Out(FIFO) principle
meaning that the first element added to the
queue will be the first one removed.
It operates with two main pointers

1. Front: Points to the first element in the queue
2. Rear: Points to the last element in the queue

### Sample implementation

```java
class Queue{
  LinkedList list;
  public Queue(){
    list = new LinkedList();
  }
  /**
   * Assume insertAtEnd and
   * deleteFromFront is implemented
   * in LinkedList
  */
  public void enqueue(int data){
    list.insertAtEnd(data);
  }
  public int dequeue(){
    return list.deleteFromFront();
  }
}
```

## What is a Queue?

A TreeNode is a basic building block for Tree data structures, like Binary Trees, Binary Search Trees (BST), and Heaps. Each node contains:

1. Data: The value stored in the node.
2. Left: A reference to the left child node.
3. Right: A reference to the right child node.

### Sample implementation

```java
class TreeNode{
  int data;
  TreeNode left, right;
  TreeNode(int data){
    this.data = data;
    this.left = null;
    this.right = null;
  }
}
class BinarySearchTree{
  TreeNode root;
  public BinarySearchTree(){
    root = null;
  }
  // Operations like insert, search, traversal would go here
}
```
