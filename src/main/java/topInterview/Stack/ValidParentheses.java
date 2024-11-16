import java.util.Stack;

class ValidParentheses{
  public boolean Solution(
    String s
  ){
    /**
     * Stack to store open brackets
     */
    Stack<Character> stack = new Stack<>();

    /**
     * Iterate through each character
     * in the string
     */
    for(char c : s.toCharArray()){
      if(
        c == '(' ||
        c == '{' ||
        c == '['
      ){
        /**
         * stack if the char is open bracket
         */
        stack.push(c);
      } else if(
        c == ')' ||
        c == '}' ||
        c == ']'
      ){
        /**
         * if the char is close bracket,
         * check if the some open 
         * bracket is stacked(stack.isEmpty())
         * and last stacked character
         * is corresponding open bracket
         */
        if(
          stack.isEmpty() ||
          !isMaching(stack.pop(),c)
        ){
          /**
           * if it does, return true
           */
          return false;
        }
      }
    }
    /**
     * finally check is there a remaining
     * open bracket which does not closed
     */
    return stack.isEmpty(); 
  }
  /**
   * reutrn true if corresponding bracket is 
   * inputed
   * @param open
   * @param close
   * @return
   */
  private boolean isMaching(char open,char close){
    return 
    (open == '(' && close == ')') ||
    (open == '{' && close == '}') ||
    (open == '[' && close == ']');
  }
}