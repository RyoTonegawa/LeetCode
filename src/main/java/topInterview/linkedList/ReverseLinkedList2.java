import javax.management.ListenerNotFoundException;

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
class ReverseLinkedList2{
  public ListNode reverseBetween(
    ListNode head,
    int left, 
    int right
    ) {
      ListNode dummy = new ListNode(0);
      dummy.next = head;
      ListNode pre = dummy;

      for(int i = 1; i<left; i++){
        pre = pre.next;
      }
      ListNode current = pre.next;
      ListNode prev = null;
      for(int i= 0;i <= right -left; i++){
        ListNode nextNode = current.next;
        current.next = prev;
        prev = current;
        current = nextNode;
      };

      pre.next.next = current;
      pre.next = prev;

      return dummy.next;
    }
}