## [Contains Duplicate II](https://leetcode.com/problems/contains-duplicate-ii/)

### Problem

Given an array of integers and an integer _k_, find out whether there there are two __distinct__ indices _i_ and _j_ in the array such that __nums[i] = nums[j]__ and the difference between _i_ and _j_ is at most _k_.

### Solution


### Code

``` Python
class Solution:
    # @param {integer[]} nums
    # @param {integer} k
    # @return {boolean}
    def containsNearbyDuplicate(self, nums, k):
        n = len(nums)
        if k == 0:
            return False
        if k >= n:
            return len(set(nums)) < n
        aList = nums[:k]
        for num in nums[k:]:
            if num in aList:
                return True
            else:
                aList = aList[1:]
                aList.append(num)
        return False
```

### Refinement
