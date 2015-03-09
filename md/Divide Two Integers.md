## [Divide Two Integers](https://leetcode.com/problems/divide-two-integers/)

### Problem

Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.

### Solution


### Code

- 64ms

``` Python
class Solution:
# @return an integer
    def divide(self, dividend, divisor):
        isPositive = (dividend < 0) is (divisor < 0)
        dividend, divisor = abs(dividend), abs(divisor)
        res = 0
        temp, i = divisor, 1
        while dividend >= temp:
            i <<= 1
            temp <<= 1
        while dividend >= divisor:
            if dividend >= temp:
                dividend -= temp
                res += i
            else:
                temp >>= 1
                i >>= 1
        if not isPositive:
            res = -res
        return min(max(-2147483648, res), 2147483647)
```

- 67ms

``` Python
class Solution:
    # @return an integer
    def divide(self, dividend, divisor):
        isPositive = (dividend < 0) is (divisor < 0)
        dividend, divisor = abs(dividend), abs(divisor)
        res = 0
        tmp
        while dividend >= divisor:
            temp, i = divisor, 1
            while dividend >= temp:
                dividend -= temp
                res += i
                i <<= 1
                temp <<= 1
        if not isPositive:
            res = -res
        return min(max(-2147483648, res), 2147483647)
```

### Refinement
