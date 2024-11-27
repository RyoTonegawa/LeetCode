public class AddTwoNumbers{
  public ListNode Solution(
    ListNode l1,
    ListNode l2
  ){
    ListNode dummy = new ListNode(0);
    ListNode current = dummy;
    int carry = 0;
    /**
     * traverse both lists
     */
    while(
      l1 != null ||
      l2 != null
    ){
      int val1 = (l1 != null)? l1.val :0 ;
      int val2 = (l2 != null)? l2.val :0;
      
      int sum = val1 + val2 + carry;
      carry = sum /10;
      current.next = new ListNode(sum % 10);
      current = current.next;
      /**
       * if there's a carry left,
       * add it as a new node
       */
      if(l1 != null) l1 = l1.next;
      if(l2 != null) l2 = l2.next;

      if(carry >0){
        current.next = new ListNode(carry);
      }
      /**
       * Return the result list,
       * (skipping the dummy node)
       */
      return dummy.next;
    };
  }
}