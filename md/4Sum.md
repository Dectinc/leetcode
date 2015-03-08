## [4Sum](https://oj.leetcode.com/submissions/detail/22507928/)

### Problem

Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

__Note__:
- Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
- The solution set must not contain duplicate quadruplets.
```
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
```

### Solution

important judgment:
- num[p4] < target / 4
- num[p1] > target / 4

### Code

``` Python
class Solution:
    # @return a list of lists of length 4, [[val1,val2,val3,val4]]
    def fourSum(self, num, target):
        results = []
        if not num or len(num) < 4:
            return results
        num.sort()
        p4 = len(num) - 1
        last4 = num[p4] - 1
        while p4 > 2:
            p1 = 0
            last1 = num[p1]-1
            if num[p4] == last4:
                p4 -= 1
                continue
            if num[p4] < target / 4:
                break
            while p1 < p4-2:
                if num[p1] == last1:
                    p1 += 1
                    continue
                if num[p1] > target / 4:
                    break
                t = target - num[p1] - num[p4]
                p2 = p1+1
                p3 = p4-1
                while p2 < p3:
                    if num[p2] + num[p3] < t:
                        p2 += 1
                        continue
                    if num[p2] + num[p3] > t:
                        p3 -= 1
                        continue
                    results.append([num[p1], num[p2], num[p3], num[p4]])
                    last2 = num[p2]
                    p2 += 1
                    while p2 < p3 and num[p2] == last2:
                        p2 += 1
                    last3 = num[p3]
                    p3 -= 1
                    while p2 < p3 and num[p3] == last3:
                        p3 -= 1
                last1 = num[p1]
                p1 += 1
            last4 = num[p4]
            p4 -= 1
        return results
```

### Refinement
