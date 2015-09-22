## [Basic Calculator II](https://leetcode.com/problems/basic-calculator-ii/)

### Problem

Implement a basic calculator to evaluate a simple expression string.

The expression string contains only __non-negative__ integers, `+`, `-`, `*`, `/` operators and empty spaces ` `. The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:
```
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
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
        numbers, ops = [], [1]
        i, n = 0, len(s)
        while i < n:
            c = s[i]
            if c.isdigit():
                cur, i = int(c), i+1
                while i < n and s[i].isdigit():
                    cur, i = cur*10+int(s[i]), i+1
                if ops and ops[-1] == '*':
                    ops.pop()
                    numbers[-1] = numbers[-1] * cur
                elif ops and ops[-1] == '/':
                    ops.pop()
                    numbers[-1] = numbers[-1] / cur
                else:
                    numbers.append(cur)
                continue
            i += 1
            if c == ' ':
                continue
            elif c == '*' or c == '/':
                ops.append(c)
            else:
                ops.append(1 if c == '+' else -1)
        return sum([x*y for x, y in zip(ops, numbers)])
```

### Refinement
