## [Combination Sum III](https://leetcode.com/problems/combination-sum-iii/)

### Problem

Find all possible combinations of __k__ numbers that add up to a number __n__, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Ensure that numbers within the set are sorted in ascending order.


__Example 1__:

Input: __k__ = 3, __n__ = 7

Output:
```
[[1,2,4]]
```
__Example 2__:

Input: __k__ = 3, __n__ = 9

Output:
```
[[1,2,6], [1,3,5], [2,3,4]]
```

### Solution


### Code

``` Python
class Solution:
    # @param {integer} k
    # @param {integer} n
    # @return {integer[][]}
    def combinationSum3(self, k, n):
        if n < k * (k+1) / 2 or n > 55:
            return []
        return self.helper(k, n, 0)

    def helper(self, k, n, m):
        if k == 0 or m > 9 or n <= m:
            return None
        if k == 1 and n < 10:
            return [[n]]
        result = []
        for i in xrange(m+1, min(n, 10)):
            rest = self.helper(k-1, n-i, i)
            if not rest:
                continue
            for _ in rest:
                result.append([i] + _)
        return result
```

### Refinement
