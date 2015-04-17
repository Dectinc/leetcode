## [Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation/)

### Problem

Evaluate the value of an arithmetic expression in [Reverse Polish Notation](http://en.wikipedia.org/wiki/Reverse_Polish_notation).

Valid operators are `+`, `-`, `*`, `/`. Each operand may be an integer or another expression.

Some examples:
```
  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
```
### Solution


### Code

``` Java
public class Solution {
    public int evalRPN(List<String> tokens) {
        String[] operatorStrings = { "+", "-", "*", "/" };
        Set<String> operators = new HashSet<String>();
        operators.addAll(Arrays.asList(operatorStrings));

        Stack<Integer> numbers = new Stack<Integer>();
        for (String token : tokens) {
            if (operators.contains(token)) {
                int b = numbers.pop();
                int a = numbers.pop();
                numbers.push(eval(a, b, token));
            } else {
                numbers.push(Integer.parseInt(token));
            }
        }

        return numbers.pop();
    }

    private int eval(int a, int b, String operator) {
        if (operator.equals("+")) {
            return a + b;
        } else if (operator.equals("-")) {
            return a - b;
        } else if (operator.equals("*")) {
            return a * b;
        } else if (operator.equals("/")) {
            return a / b;
        }
        return 0;
    }
}
```

### Refinement
