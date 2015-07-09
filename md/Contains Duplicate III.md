## [Contains Duplicate III](https://leetcode.com/problems/contains-duplicate-iii/)

### Problem

Given an array of integers, find out whether there are two distinct indices _i_ and _j_ in the array such that the difference between __nums[i]__ and __nums[j]__ is at most t and the difference between _i_ and _j_ is at most _k_.

### Solution


### Code

``` Python
class Solution:
    # @param {integer[]} nums
    # @param {integer} k
    # @param {integer} t
    # @return {boolean}
    def containsNearbyAlmostDuplicate(self, nums, k, t):
        n = len(nums)
        if k == 0:
            return False
        ind = sorted(xrange(n), key=lambda x: nums[x])
        for i in xrange(n - 1):
            j = i + 1
            margin = nums[ind[i]] + t
            while j < n and nums[ind[j]] <= margin:
                if abs(ind[i] - ind[j]) <= k:
                    return True
                j += 1
        return False
```

### Refinement
