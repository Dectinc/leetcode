## [Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/)

### Problem

Given an array of __n__ positive integers and a positive integer __s__, find the minimal length of a subarray of which the sum ≥ __s__. If there isn't one, return 0 instead.

For example, given the array `[2,3,1,2,4,3]` and `s = 7`,

the subarray `[4,3]` has the minimal length under the problem constraint.

### Solution


### Code

- O(n log n) solution
``` Python
class Solution:
    # @param {integer} s
    # @param {integer[]} nums
    # @return {integer}
    def minSubArrayLen(self, target, nums):
        result = len(nums) + 1
        for idx, n in enumerate(nums[1:], 1):
            nums[idx] = nums[idx - 1] + n
        left = 0
        for right, n in enumerate(nums):
            if n >= target:
                left = self.find_left(left, right, nums, target, n)
                result = min(result, right - left + 1)
        return result if result <= len(nums) else 0

    def find_left(self, left, right, nums, target, n):
        while left < right:
            mid = (left + right) // 2
            if n - nums[mid] >= target:
                left = mid + 1
            else:
                right = mid
        return left
```

- O(n) solution
``` Python
class Solution:
    # @param {integer} s
    # @param {integer[]} nums
    # @return {integer}
    def minSubArrayLen(self, s, nums):
        total, left = 0, 0
        result = len(nums) + 1
        for right, n in enumerate(nums):
            total += n
            while total >= s:
                result = min(result, right-left+1)
                total -= nums[left]
                left += 1
        return result if result <= len(nums) else 0
```

### Refinement
