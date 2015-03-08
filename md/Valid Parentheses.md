## [Valid Parentheses](https://oj.leetcode.com/problems/valid-parentheses/)

### Problem

Given a string containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid.

The brackets must close in the correct order, `"()"` and `"()[]{}"` are all valid but `"(]"` and `"([)]"` are not.

### Solution

Use stack

### Code

``` Python
class Solution:
    # @return a boolean
    def isValid(self, s):
        p = []
        for c in s:
            if c == '(':
                p.append(')')
            elif c == '[':
                p.append(']')
            elif c == '{':
                p.append('}')
            else:
                if len(p) == 0:
                    return False
                top = p.pop()
                if not c == top:
                    return False
        return len(p) == 0
```

### Refinement
