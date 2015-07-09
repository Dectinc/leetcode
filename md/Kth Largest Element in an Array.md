## [Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/)

### Problem

Find the __k__th largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

For example,
Given `[3,2,1,5,6,4]` and k = 2, return 5.

__Note:__

You may assume k is always valid, 1 ≤ k ≤ array's length.

### Solution


### Code

``` Python
class Solution:
    # @param {integer[]} nums
    # @param {integer} k
    # @return {integer}
    def findKthLargest(self, nums, k):
        n = len(nums)
        for cur in xrange(1, k):
            i, j = cur, (cur-1) // 2
            while i > 0 and nums[i] < nums[j]:
                nums[i], nums[j] = nums[j], nums[i]
                i = j
                j = (i-1) // 2
        for i in xrange(k, n):
            if nums[i] <= nums[0]:
                continue
            nums[0] = nums[i]
            j = 0
            child = 2*j + 1
            while child < k:
                if child < k-1 and nums[child] > nums[child+1]:
                    child += 1
                if nums[j] <= nums[child]:
                    break
                nums[j], nums[child] = nums[child], nums[j]
                j = child
                child = 2*j + 1
        return nums[0]
```

### Refinement
