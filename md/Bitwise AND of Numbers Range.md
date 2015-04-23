## [Bitwise AND of Numbers Range](https://leetcode.com/problems/bitwise-and-of-numbers-range/)

### Problem

Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.

For example, given the range [5, 7], you should return 4.

### Solution


### Code

``` Java
public class Solution {
	public int rangeBitwiseAnd(int m, int n) {
		if (m == n) {
			return m;
		}
		int nums = n - m, t = m;
		int result = 0, pos = 0;

		while (m > 0) {
			pos++;
			int curRoutine = (int) Math.pow(2, pos);
			if ((m & 1) == 1
					&& (t % curRoutine + nums < curRoutine || curRoutine == Integer.MAX_VALUE)) {
				result = 1 << (pos - 1) | result;
			}
			m = m >> 1;
		}
		return result;
	}
}
```

### Refinement
