## [Count Primes](https://leetcode.com/problems/count-primes/)

### Problem

Count the number of prime numbers less than a non-negative number, __n__

### Solution

Note the optimalization that, while set flags after i, we can start from i*i, because numbers which is less than i times of i have been set before i was reached.

### Code

``` Python
class Solution:
    # @param {integer} n
    # @return {integer}
    def countPrimes(self, n):
        if n < 3:
            return 0
        count = 1
        flags = [False] * n;
        for i in xrange(3, n, 2):
            if not flags[i]:
                count += 1
            else:
                continue
            j = i*i
            while j < n:
                flags[j] = True
                j += i
        return count
```

### Refinement
