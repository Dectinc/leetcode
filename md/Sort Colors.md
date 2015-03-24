## [Sort Colors](https://leetcode.com/problems/sort-colors/)

### Problem

Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

__Note__:

You are not suppose to use the library's sort function for this problem.

__Follow up__:

A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?

### Solution


### Code

- 2-pass

``` Python
class Solution:
    # @param A a list of integers
    # @return nothing, sort in place
    def sortColors(self, A):
        length = len(A)
        if length < 2:
            return
        i = 0
        j = length
        for a in A:
            if a == 0:
                i += 1
            if a == 2:
                j -= 1
        for m in range(i):
            A[m] = 0
        for m in range(i, j):
            A[m] = 1
        for m in range(j, length):
            A[m] = 2
```

- 1-pass

``` Python
class Solution:
    # @param A a list of integers
    # @return nothing, sort in place
    def sortColors(self, A):
        i, j, k = 0, 0, len(A)-1
        while i <= k:
            if A[i] == 0:
                A[i], A[j] = A[j], A[i]
                i += 1
                j += 1
            elif A[i] == 2:
                A[i], A[k] = A[k], A[i]
                k -= 1
            else:
                i += 1
```

### Refinement
