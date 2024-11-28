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
class removeNthFromEndOfList {
  public ListNode Solution (
    ListNode head,
    int n
    ) {
      //Add a dummy node to simplify edge case
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    // Initialize two pointer
    ListNode first = dummy;
    ListNode second = dummy;
    // Move the first pointer n+1 steps ahead
    for(int i = 0; i <= n; i++){
      first = first.next;
    }
    //Move both pointers until 
    //first reached the end
    while(first != null){
      first = first.next;
      second = second.next;
    }
    second.next= second.next.next;
    return dummy.next;
  }
}