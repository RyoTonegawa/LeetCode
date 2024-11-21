/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LinkedListCycle{
  public boolean Solution(
    ListNode head
  ){
    /**
     * Base case
     * if the list is empty or has only one node,
     * there is no cycle
     */
    if(
      head == null ||
      head.next == null
    ){
      return false;
    }
    ListNode slow = head;
    ilstNode fast = head;
    /**
     * Traverse the list
     */
    while(
      fast != null &&
      fast.next != null
    ){
      slow = slow.next;
      fast = fast.next.next;

      if(
        slow == fast
      ){
        return true;
      }
    }
    /**
     * No cycle found
     */
    return false;
  };
}