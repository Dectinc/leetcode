## [Valid Number](https://oj.leetcode.com/problems/valid-number/)

### Problem

Validate if a given string is numeric.

Some examples:
- `"0"` => `true`
- `" 0.1 "` => `true`
- `"abc"` => `false`
- `"1 a"` => `false`
- `"2e10"` => `true`
Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.

### Solution

Traversal

### Code

``` Python
class Solution:
    # @param s, a string
    # @return a boolean
    def isNumber(self, s):
        if not s:
            return False
        s = s.strip()
        if len(s) == 0:
            return False
        pointSeen = False
        eSeen = False
        numberSeen = False
        numberAfterE = True
        lastC = ''
        for c in s:
            if c.isdigit():
                numberSeen = True
                numberAfterE = True
            elif c == '.':
                if eSeen or pointSeen:
                    return False
                pointSeen = True
            elif c == 'e':
                if eSeen or not numberSeen:
                    return False
                numberAfterE = False
                eSeen = True
            elif c == '-' or c == '+':
                if lastC not in ['', 'e', 'E']:
                    return False
            else:
                return False
            lastC = c
        return numberSeen and numberAfterE
```

### Refinement
