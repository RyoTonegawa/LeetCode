/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
  public Node copyRandomList(Node head) {
      if(head == null){
      return null;
    }
    // Step1 Interweave the original
    // and copied nodes
    Node current = head;
    while(current!= null){
      Node copy = new Node(current.val);
      copy.next= current.next;
      // Why do we substitute copy into 
      // original Node(current.next)?
      current.next = copy;
      current = copy.next;
    }
    // Step2 Assign random pointers
    // to the copied nodes
    current = head;
    while(current != null){
      if(current.random != null){
        //why do we copy nodes by 
        // insert into current nodes value from
        // current nodes?
        current.next.random = current.random.next;
      }

      current = current.next.next;
    }
    // Step3 Separate the interleaved lists
    // what are we doing here?
    Node original = head;
    Node copyHead = head.next;
    Node copy = copyHead;
    while(
      original != null
    ){
      original.next = original.next.next;
      if(copy.next != null){
        copy.next = copy.next.next;
      }
      original = original.next;
      copy = copy.next;
    };
    return copyHead;
  }
}