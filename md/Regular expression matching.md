## [Regular expression matching](http://oj.leetcode.com/problems/regular-expression-matching/)

### Problem

Implement regular expression matching with support for ‘.’ and ‘*’.

‘.’ Matches any single character.

‘*’ Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:

bool isMatch(const char *s, const char *p)

Some examples:

- isMatch(“aa”,”a”) → false
- isMatch(“aa”,”aa”) → true
- isMatch(“aaa”,”aa”) → false
- isMatch(“aa”, “a*”) → true
- isMatch(“aa”, “.*”) → true
- isMatch(“ab”, “.*”) → true
- isMatch(“aab”, “c*a*b”) → true

### Solution

Dynamic programming

### Code

``` java
public class Solution {
	char[] ss = null;
	char[] pp = null;
	int lenS = 0;
	int lenP = 0;

	public boolean isMatch(String s, String p) {
		if (p == null) {
			return s == null;
		}
		ss = s.toCharArray();
		pp = p.toCharArray();
		lenS = ss.length;
		lenP = pp.length;
		if (lenP == 0) {
			return lenS == 0;
		}

		return match(0, 0);
	}

	private boolean match(int i, int j) {
		if (i == lenS && j == lenP) {
			return true;
		}
		if (j + 1 < lenP && pp[j + 1] != '*') {
			if (i < lenS && match(ss[i], pp[j])) {
				return match(i + 1, j + 1);
			}
			return false;
		} else if (j + 1 < lenP) {
			while (i < lenS && match(ss[i], pp[j])) {
				if (match(i, j + 2)) {
					return true;
				}
				i++;
			}
			return match(i, j + 2);
		}
		return i == lenS - 1 && j == lenP - 1 && match(ss[i], pp[j]);
	}

	private boolean match(char sc, char pc) {
		if (pc == '.') {
			return true;
		}
		return sc == pc;
	}
}
```

### Refinement