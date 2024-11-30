 public class ListNode {
       int val;
      ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }

public class RotateList{

  public ListNode rotateRight(
    ListNode head,
    int k
    ) {
        // Handle edge case
        if(
          k == 0 ||
          head == null ||
          head.next == null
        ){
          return head;
        }

        // Find the length of the list
        ListNode tail = head;
        int length = 1;
        while(
          tail.next != null
        ){
          tail = tail.next;
          length++;
        }

        // Adjust k
        k = k % length;
        if(k == 0){
          // No rotation needed
          return head;
        };
        // Form a circular list
        /**
         * To simplify the traversal Logic
         * if we connect tail.next with head
         * then we don't manually connect
         * new tail with new head.
         * This Linked List is called 
         * circulat list.
         * circular list's tail
         * is connected to the first node.
         */
        tail.next = head;

        // find the new tail
        int stepsToNewTail = length - k;
        ListNode newTail = head;
        for(
          int i= 1; i< stepsToNewTail; i++
        ){
          newTail = newTail.next;
        };
        // Setting new head 
        // Then I have a question
        /**
         * Why we don't connect nodes from
         * k+1th to newTail after the kth Node?
         */ 
        ListNode newHead = newTail.next;
        newTail.next = null;
        /**
         * thie Logic
         * newtail.next = null;
         * means cut the circular list
         * and form a rotated list
         */
        return newHead;

      }
}