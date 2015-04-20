## [Fraction to Recurring Decimal](https://leetcode.com/problems/fraction-to-recurring-decimal/)

### Problem

Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

For example,

- Given numerator = 1, denominator = 2, return "0.5".
- Given numerator = 2, denominator = 1, return "2".
- Given numerator = 2, denominator = 3, return "0.(6)".


### Solution

```
CAUTION:

a. Positive and negative
b. Integer.MIN_VALUE
```

### Code

``` Java
public class Solution {
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
}
```

### Refinement
