import java.util.Stack;

public class EvaluateReversePolishNotation{
  public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();
    for(String token:tokens){
      if(
        isOperator(token)
      ){
        /**
         * If token is a opoerator,
         * pop top two element from 
         * stack and both of them are 
         * numbers.
         * Because in RPN, 
         * operator is always written
         * after the numbers. 
         */
        int b = stack.pop();
        int a = stack.pop();
        //Evaluate according to the operator
        stack.push(applyOperation(a, b, token));
      }else{
        stack.push(Integer.paseInt(token));
      }
    }
    return stack.pop();
  }
  private boolean isOperator(String token){
    return 
    token.equals("+") ||
    token.equals("-") ||
    token.equals("*") ||
    token.equals("/");

  }
  private int applyOperation(
    int a,
    int b,
    String operator
  ){
    switch(operator){
      case "+":
        return a+b;
      case "-":
        return a-b;
      case "*":
        return a*b;
      case "/":
        //Integer division truncates
        //towards zero
        return a/b;
      default:
        throw new IllegalArgumentException(
          "Invalid oprator: " + operator
        );

    }
    
  };
}