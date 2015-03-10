## [Search for a Range](https://leetcode.com/problems/search-for-a-range/)

### Problem

Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return `[-1, -1]`.

For example,
Given `[5, 7, 7, 8, 8, 10]` and target value 8,
return `[3, 4]`.

### Solution


### Code

``` Python
class Solution:
    # @param A, a list of integers
    # @param target, an integer to be searched
    # @return a list of length 2, [index1, index2]
    def searchRange(self, A, target):
        left = self.binarySearch(A, target-0.5)
        if A[left] != target:
            return [-1, -1]
        A.append(0)
        right = self.binarySearch(A, target+0.5)
        return [left, right-1]

    def binarySearch(self, A, target):
        start, end = 0, len(A)-1
        while start < end:
            mid = (start+end)/2
            if A[mid] > target:
                end = mid
            else:
                start = mid+1
        return start
```

### Refinement
