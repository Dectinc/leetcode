## [Remove Duplicates from Sorted Array II](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/)

### Problem

Follow up for "Remove Duplicates":

What if duplicates are allowed at most twice?

For example,

Given sorted array A = `[1,1,1,2,2,3]`,

Your function should return length = `5`, and A is now `[1,1,2,2,3]`. 

### Solution


### Code

``` Python
class Solution:
    # @param A a list of integers
    # @return an integer
    def removeDuplicates(self, A):
        if len(A) < 3:
            return len(A)
        lastlast, last= A[:2]
        length = len(A)
        p = 2
        while p < length:
            cur = A[p]
            if lastlast == last and cur == last:
                del A[p]
                length -= 1
            else:
                lastlast, last = last, cur
                p += 1
        return length
```

### Refinement
