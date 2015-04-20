/**
 * 
 */
package cc.dectinc.leetcode;

import java.util.HashMap;

/**
 * @author Dectinc
 * @version Apr 20, 2015 8:38:15 PM
 * 
 */
public class FractionToRecurringDecimal {
	/*
	 * CAUTION:
	 * 
	 * a. Positive and negative
	 * b. Integer.MIN_VALUE
	 */
	public String fractionToDecimal(int numeratorInt, int denominatorInt) {
		if (denominatorInt == 0) {
			return String.valueOf(Integer.MAX_VALUE);
		} else if (numeratorInt == 0) {
			return "0";
		}
		StringBuffer sb = new StringBuffer();

		boolean flag = (numeratorInt > 0) ^ (denominatorInt > 0);
		long numerator = Math.abs((long) numeratorInt);
		long denominator = Math.abs((long) denominatorInt);
		if (flag) {
			sb.append("-");
		}

		long prev = numerator / denominator;
		sb.append(prev);
		long residual = numerator % denominator;
		if (residual == 0) {
			return sb.toString();
		} else {
			sb.append(".");
		}
		int count = 1;
		HashMap<Long, Integer> residualMap = new HashMap<Long, Integer>();
		while (residual != 0 && !residualMap.containsKey(residual)) {
			residualMap.put(residual, count++);
			residual *= 10;
			sb.append(residual / denominator);
			residual %= denominator;
		}
		String result = sb.toString();
		if (residual != 0) {
			int splitIndex = result.length() + residualMap.get(residual)
					- count;
			result = result.substring(0, splitIndex) + "("
					+ result.substring(splitIndex) + ")";
		}
		return result;
	}

	public static void main(String[] args) {
		FractionToRecurringDecimal sol = new FractionToRecurringDecimal();
		int numerator = 1;
		int denominator = Integer.MIN_VALUE;
		System.out.println(sol.fractionToDecimal(numerator, denominator));
	}
}
