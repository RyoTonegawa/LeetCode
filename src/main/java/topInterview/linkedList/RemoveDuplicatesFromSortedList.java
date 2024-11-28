public class RemoveDuplicateFromSortedList{
  public ListNode deleteDuplicates(
    ListNode head
    ) {
        // create a dummy node
        ListNode dummy = new ListNode(0,head);
        ListNode prev = dummy;

        // Traverse the list
        ListNode current = head;
        while(current != null){
          // Check if the current node has duplicate
          if(
            current.next != null &&
            current.val == current.next.val
          ){
            // Skip all nodes with the same value
            while(
              current.next != null &&
              current.val == current.next.val
              ){
                // Connect previous
                // to the first distinct
                // value
                current = current.next;
              }
              prev.next = current.next;
          } else{
            // Move prev forward only if
            // there are no duplicates
            prev = prev.next;
          }
          // move current forward
          current = current.next;
        }
        // Return the new head
        return dummy.next;
  }
}