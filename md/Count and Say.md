## [Count and Say](http://oj.leetcode.com/problems/count-and-say/)

**Problem**

The count-and-say sequence is the sequence of integers beginning as follows:

`1, 11, 21, 1211, 111221, ...`

`1` is read off as `"one 1"` or `11`.

`11` is read off as `"two 1s"` or `21`.

`21` is read off as `"one 2, then one 1"` or `1211`.

Given an integer _n_, generate the _nth_ sequence.

Note: The sequence of integers will be represented as a string.

**Solution**

Simply simulate the process.

**Code**

``` java
public class Solution {
    public String countAndSay(int n) {
		if (n == 0) {
			return "";
		} else if (n == 1) {
			return "1";
		}

		char[] last = { '1' };
		StringBuffer sb = null;

		for (int i = 1; i < n; i++) {
			int count = 0;
			char tmpChar = ' ';
			sb = new StringBuffer();
			for (char c : last) {
				if (c == tmpChar) {
					count++;
				} else {
					if (count != 0) {
						sb.append(count);
						sb.append(tmpChar);
					}
					tmpChar = c;
					count = 1;
				}
			}
			sb.append(count);
			sb.append(tmpChar);
			last = sb.toString().toCharArray();
		}

		return sb.toString();
    }
}
```

**Refinement**