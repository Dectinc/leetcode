## [Summary Ranges](https://leetcode.com/problems/summary-ranges/)

### Problem

Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given `[0,1,2,4,5,7]`, return `["0->2","4->5","7"]`.

### Solution


### Code

``` Python
class Solution(object):
    def summaryRanges(self, nums):
        """
        :type nums: List[int]
        :rtype: List[str]
        """
        if not nums:
            return []
        elif len(nums) == 1:
            return [str(nums[0])]
        res = []
        curLow, last = nums[0], nums[0]
        for cur in nums[1:]:
            if cur > last+1:
                res.append(str(last) if curLow == last else '%d->%d' % (curLow, last))
                curLow = last = cur
            else:
                last = cur
        res.append(str(last) if curLow == last else '%d->%d' % (curLow, last))
        return res
```

### Refinement
