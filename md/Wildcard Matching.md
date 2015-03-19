## [Wildcard Matching](https://leetcode.com/problems/wildcard-matching/)

### Problem

Implement wildcard pattern matching with support for `'?'` and `'*'`.
```
'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false
```

### Solution

- Since the current row only depends on the previous row, we can use two rolling lists to do the dp instead of a matrix.

### Code

``` Python
class Solution:
    # @param s, an input string
    # @param p, a pattern string
    # @return a boolean
    def isMatch(self, s, p):
        lens = len(s)
        lenp = len(p)
        if lens+lenp == 0:
            return True
        if lenp - p.count('*') > lens:
            return False
        curRow = [False] * (lens + 1)
        lastRow = [False] * lens + [True]
        for i in range(lenp):
            pi = p[i]
            curRow[-1] = lastRow[-1] and pi == '*'
            if pi == '*':
                for j in range(lens):
                    curRow[j] = curRow[j - 1] or lastRow[j]
            elif pi == '?':
                for j in range(lens):
                    curRow[j] = lastRow[j - 1]
            else:
                for j in range(lens):
                    curRow[j] = lastRow[j - 1] and pi == s[j]
            lastRow = curRow[:]
        return curRow[lens-1]
```

### Refinement
