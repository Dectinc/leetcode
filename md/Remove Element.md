## [Remove Element](https://leetcode.com/problems/remove-element/)

### Problem

Given an array and a value, remove all instances of that value in place and return the new length.

__The order of elements can be changed__. It doesn't matter what you leave beyond the new length.

### Solution


### Code

``` Python
class Solution:
    # @param    A       a list of integers
    # @param    elem    an integer, value need to be removed
    # @return an integer
    def removeElement(self, A, elem):
        if not A or len(A) == 0:
            return 0
        i = 0
        j = len(A)
        while i < j:
            if A[i] == elem:
                j -= 1
                A[i] = A[j]
            else:
                i += 1
        return i
```

### Refinement
