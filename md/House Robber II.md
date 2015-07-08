## [House Robber II](https://leetcode.com/problems/house-robber-ii/)

### Problem

__Note:__ This is an extension of [House Robber](https://leetcode.com/problems/house-robber/).

After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are __arranged in a circle__. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight __without alerting the police__.

### Solution

Just do a non-cicle robbery twice.

### Code

``` Python
class Solution:
    # @param {integer[]} nums
    # @return {integer}
    def rob(self, nums):
        n = len(nums)
        if n == 0:
            return 0
        elif n == 1:
            return nums[0]
        return max(self.robOnce(nums[1:]), self.robOnce(nums[:n-1]))

    def robOnce(self, nums):
        last = 0
        pre = nums[0]
        for i in xrange(1, len(nums)):
            cur = max(pre, last+nums[i])
            last = pre
            pre = cur
        return pre

```

### Refinement
