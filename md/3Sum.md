## [3Sum](https://oj.leetcode.com/problems/3sum/)

### Problem

Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

**Note**:
- Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
- The solution set must not contain duplicate triplets.
```
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
```

### Solution

Using bi-search

### Code

``` Python
class Solution:
    # @return a list of lists of length 3, [[val1,val2,val3]]
    def threeSum(self, num):
        results = []
        if not num or len(num) < 3:
            return results
        num.sort()
        length = len(num)
        first = 0
        while first < length - 2:
            num1 = num[first]
            if num1 > 0:
                return results
            second = first + 1
            third = length - 1
            while second < third:
                while num1 + num[second] + num[third] < 0:
                    second += 1
                    if second == third:
                        break
                while num1 + num[second] + num[third] > 0:
                    third -= 1
                    if second == third:
                        break
                if second < third and num1 + num[second] + num[third] == 0:
                    results.append([num1, num[second], num[third]])
                    lastNum2 = num[second]
                    lastNum3 = num[third]
                    second += 1
                    third -= 1
                    while second < third and num[second] == lastNum2:
                        second += 1
                    while second < third and num[third] == lastNum3:
                        third -= 1
            first += 1
            while first < length - 2 and num[first] == num1:
                first += 1
        return results
```

### Refinement
