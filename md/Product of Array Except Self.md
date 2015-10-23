## [Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/)

### Problem

Given an array of __n__ integers where __n__ > 1, `nums`, return an array `output` such that `output[i]` is equal to the product of all the elements of `nums` except `nums[i]`.

Solve it without division and in O(__n__).

For example, given `[1,2,3,4]`, return `[24,12,8,6]`.

__Follow up__:

Could you solve it with constant space complexity? (Note: The output array __does not__ count as extra space for the purpose of space complexity analysis.)

### Solution


### Code

``` Python
class Solution(object):
    def productExceptSelf(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        n = len(nums)
        results = [1] * n
        cur = 1
        for i in xrange(n):
            results[i] = cur
            cur *= nums[i]
        cur = 1
        for i in range(n-1, -1, -1):
            results[i] *= cur
            cur *= nums[i]
        return results
```

### Refinement
