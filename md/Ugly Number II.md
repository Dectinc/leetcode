## [Ugly Number II](https://leetcode.com/problems/ugly-number-ii/)

### Problem

Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include `2, 3, 5`. For example, `1, 2, 3, 4, 5, 6, 8, 9, 10, 12` is the sequence of the first `10` ugly numbers.

Note that `1` is typically treated as an ugly number.

### Solution

- The naive approach is to call isUgly for every number until you reach the nth one. Most numbers are not ugly. Try to focus your effort on generating only the ugly ones.
- An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
- The key is how to maintain the order of the ugly numbers. Try a similar approach of merging from three sorted lists: L1, L2, and L3.
- Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).

### Code

``` Python
class Solution(object):
    def nthUglyNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        if n == 1:
            return 1
        uglyFactors = (2, 3, 5)
        times = [[x] for x in uglyFactors]
        numFactors = len(uglyFactors)
        cur = 1
        for i in xrange(1, n):
            curMin, q = times[0][0], 0
            for j in range(1, numFactors):
                if times[j][0] < curMin:
                    curMin = times[j][0]
                    q = j
            cur = times[q][0]
            times[q] = times[q][1:]
            for j in range(q, numFactors):
                times[j].append(cur*uglyFactors[j])
        return cur
```

``` Python
class Solution(object):
    def nthUglyNumber(self, n):
        ugly = [1]
        i2, i3, i5 = 0, 0, 0
        while n > 1:
            u2, u3, u5 = 2 * ugly[i2], 3 * ugly[i3], 5 * ugly[i5]
            umin = min((u2, u3, u5))
            if umin == u2:
                i2 += 1
            if umin == u3:
                i3 += 1
            if umin == u5:
                i5 += 1
            ugly.append(umin)
            n -= 1
        return ugly[-1]
```

### Refinement
