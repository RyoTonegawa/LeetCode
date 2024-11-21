import java.util.Stack;

public class MinStack{
  private Stack<Integer> stack;
  private Stack<Integer> minStack;
  public MinStack() {
    stack = new Stack<>();
    minStack = new Stack<>();
  } 
  /**
   * push the element onto the 
   * main stack.
   * If the element is smaller than or 
   * equal to the current minimum,
   * push it onto the min stack as well.
   * @param val
   */
  public void push(int val) {
      stack.push(val);
      /**
       * Push to minStack only if it's
       * empty or the new value is 
       * <= current minimum
       */
      // Q:how does .peek works?
      if(
        minStack.isEmpty()||
        val <= minStack.peek()
      ){
        minStack.push(val);
      }
  }
  
  public void pop() {
      /**
       * Remove the top element from
       * both stacks if they match.
       * Because situation of the min number
       * and top of the stack number matches
       * mean minimum number is removed
       * from the stack
       */
      if(
        stack.peek().equals(minStack.peek())
      ){
        minStack.pop();
      }
      stack.pop();
  }
  
  public int top() {
    /**
     * Simply returns top of the stack 
     */  
    return stack.peek();
  }
  
  public int getMin() {
    /**
     * Simply returns min number
     */
      return minStack.peek();
  }
}