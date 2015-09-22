## [Basic Calculator](https://leetcode.com/problems/basic-calculator/)

### Problem

Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

You may assume that the given expression is always valid.

Some examples:
```
"1 + 1" = 2
" 2-1 + 2 " = 3
"(1+(4+5+2)-3)+(6+8)" = 23
```

### Solution


### Code

``` Python
class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        sum = 0
        q = [1, 1]
        n, i = len(s), 0
        while i < n:
            if s[i].isdigit():
                cur, i = int(s[i]), i+1
                while i<n and s[i].isdigit():
                    cur, i = cur*10 + int(s[i]), i+1
                sum += cur * q.pop()
                continue
            c, i = s[i], i+1
            if c == '+' or c == '(':
                q.append(q[-1])
            elif c == '-':
                q.append(-q[-1])
            elif c == ')':
                q.pop()
        return sum
```

### Refinement
