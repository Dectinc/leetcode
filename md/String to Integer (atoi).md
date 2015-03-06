## [String to Integer (atoi)](https://oj.leetcode.com/problems/string-to-integer-atoi/)

### Problem

Implement atoi to convert a string to an integer.

__Hint__: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

__Notes__: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

*spoilers alert...*

**Requirements for atoi**:

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.

### Solution


### Code

``` Python
INT_MAX = 2147483647
INT_MIN = 2147483648

def getResult(number, isNegative):
    if isNegative:
        return -number
    else:
        return number

class Solution:
    # @return an integer
    def atoi(self, str):
        if not str:
            return 0
        str = str.strip()
        if len(str) == 0:
            return 0
        isNegative = False
        if str[0] == '-' or str[0] == '+':
            isNegative = str[0] == '-'
            str = str[1:]
        result = 0
        for c in str:
            if not c.isdigit():
                return getResult(result, isNegative)
            result = result * 10 + int(c)
            if isNegative and result > INT_MIN:
                return - INT_MIN
            if not isNegative and result > INT_MAX:
                return INT_MAX
        return getResult(result, isNegative)
```

### Refinement
