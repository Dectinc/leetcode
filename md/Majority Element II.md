## [Majority Element II](https://leetcode.com/problems/majority-element-ii/)

### Problem

Given an integer array of size n, find all elements that appear more than `[n/3]` times. The algorithm should run in linear time and in O(1) space.

### Solution


### Code

``` Python
class Solution(object):
    def majorityElement(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        if len(nums) < 3:
            return list(set(nums))
        candidates = [0, 0]
        votes = [0, 0]
        n = 2
        for i in xrange(len(nums)):
            cur = nums[i]
            flag = False
            for j in xrange(n):
                if votes[j] > 0 and cur == candidates[j]:
                    votes[j] += 1
                    flag = True
                    break
            if flag:
                continue
            for j in xrange(n):
                if votes[j] == 0:
                    candidates[j], votes[j] = cur, 1
                    flag = True
                    break;
            if flag:
                continue
            for j in xrange(n):
                votes[j] -= 1
        res = []
        for candidate in set(candidates):
            if nums.count(candidate) > len(nums) // 3:
                res.append(candidate)
        return res
```

### Refinement
