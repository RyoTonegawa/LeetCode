/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
  public ListNode partition(
    ListNode head,
    int x
    ) {
      // Create dummy nodes for the two pointers
      ListNode lessDummy = new ListNode(0);
      ListNode greaterDummy = new ListNode(0);
      // Pointers to track the 'end' of both lists
      /**
       * Why are we creating anoter ListNode
       * and not use less and greater dummy node 
       * directory ?
       * 
       * Answer:
       * To preserve the first node of
       * the respective lists.
       * first node pointer is lessDummy and
       * greaterDummy.
       * And then, less and greater allows us to
       * process final node of respective 
       * lists.
       */
      ListNode less = lessDummy;
      ListNode greater = greaterDummy;
      /**
       * Traverse input list and
       * create less and greater list.
       */
      ListNode current = head;
      while(
        current != null
      ){
        if(current.val < x){
          // Add to less list
          less.next = current;
          /**
           * Once substituting less node
           * ,move less node to newer 
           * less node.
           * next time we directory
           * add less node to next node
           * of current less node.
           */
          less = less.next;
        }else{
          // Add to greater list
          greater.next = current;
          greater = greater.next;
        }
        // Move to the next node
        // in the input list
        current = current.next;
      }
      // Connect less linkedList and
      // greater linked List
      less.next = greaterDummy.next;
      /** 
       * substitute null to terminate
       * new linked list.
       * to avoid cycles
      */
      greater.next = null;

      return lessDummy.next;
  }
}