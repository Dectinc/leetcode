/**
 * 
 */

package cc.dectinc.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * @author chenshijiang
 * @date Apr 17, 2015 9:45:56 AM
 * 
 */
public class EvaluateReversePolishNotation {
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

	public static void main(String[] args) {
		EvaluateReversePolishNotation sol = new EvaluateReversePolishNotation();
		String[] tokenArray = { "2", "1", "+", "3", "*" };
		List<String> tokens = Arrays.asList(tokenArray);
		System.out.println(sol.evalRPN(tokens));
	}

}
