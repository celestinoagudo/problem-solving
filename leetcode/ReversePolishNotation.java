package leet.code.practice.set;

import java.util.Set;
import java.util.Stack;

public class ReversePolishNotation {

  public static void main(String[] args) {
    System.out.println("Result: " + evaluate(new String[] {"4", "13", "5", "/", "+"}));
  }

  /**
   * The problem: Evaluate the value of an arithmetic expression in Reverse Polish Notation. Valid
   * operators are +, -, *, /. Each operand may be an integer or another expression. Some examples:
   * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
   * 
   * @param expression to evaluate
   * @return evaluation result
   */
  private static int evaluate(final String[] expression) {
    var operands = new Stack<Integer>();
    var operators = Set.of("+", "-", "*", "/");
    for (var element : expression) {
      if (!operators.contains(element)) {
        operands.push(Integer.valueOf(element));
      } else {
        var second = operands.pop();
        var first = operands.pop();
        switch (element) {
          case "+": {
            operands.push(first + second);
            break;
          }
          case "*": {
            operands.push(first * second);
            break;
          }
          case "-": {
            operands.push(first - second);
            break;
          }
          default: {
            operands.push(first / second);
          }
        }
      }
    }
    return operands.pop();
  }
}
