## [Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/    )

### Problem

Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,

Given input array A = `[1,1,2]`,

Your function should return length = `2`, and A is now `[1,2]`.

### Solution


### Code

``` Python
class Solution:
    # @param a list of integers
    # @return an integer
    def removeDuplicates(self, A):
        if not A or len(A) == 0:
            return 0
        insertIndex = 1
        for i in range(1, len(A)):
            if A[i] != A[insertIndex-1]:
                A[insertIndex] = A[i]
                insertIndex += 1
        return insertIndex
```

### Refinement
