## [Happy Number](https://leetcode.com/problems/happy-number/)

### Problem

Write an algorithm to determine if a number is "happy".

A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

__Example__: 19 is a happy number

1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1

### Solution


### Code

``` Python
class Solution:
    # @param {integer} n
    # @return {boolean}
    def isHappy(self, n):
        occured = []
        next = n
        while True:
            next = self.getNext(next);
            if next == 1:
                return True
            if next in occured:
                return False
            occured.append(next)
        
    def getNext(self, n):
        next = 0
        while n > 0:
            a = n%10
            next += a*a
            n /= 10
        return next
        
```

### Refinement
