## [Pow(x, n)](https://leetcode.com/problems/powx-n/)

### Problem

Implement pow(x, n).

### Solution


### Code

``` Python
class Solution:
    # @param x, a float
    # @param n, a integer
    # @return a float
    def pow(self, x, n):
        if x == 0: return 0
        if x == 1: return 1
        if n == 0: return 1
        if n == 1: return x
        if n < 0: return 1/self.pow(x, -n)
        result = 1
        tmp  = self.pow(x, n/2)
        if n&1:
            result = tmp*tmp*x
        else:
            result = tmp*tmp
        return result
```

### Refinement
