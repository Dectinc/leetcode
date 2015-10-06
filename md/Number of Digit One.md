## [Number of Digit One](https://leetcode.com/problems/number-of-digit-one/)

### Problem

Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

For example:

Given n = 13,

Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.

__Hine:__

Beware of overflow.

### Solution


### Code

``` Python
class Solution(object):
    def countDigitOne(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n < 1:
            return 0
        nn = '0' + str(n)
        l = len(nn)
        count = n / 10 + (0 if n % 10 == 0 else 1)
        for i in xrange(1, l-1):
            c = int(nn[i])
            base = 10 ** (l-i-1)
            count += int(nn[0:i]) * base
            if c == 1:
                count += int(nn[i+1:])+1
            elif c > 1:
                count += base
        return count
```

### Refinement
