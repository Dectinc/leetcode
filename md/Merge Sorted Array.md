## [Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/)

### Problem

Given two sorted integer arrays A and B, merge B into A as one sorted array.

__Note:__

You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.

### Solution


### Code

``` Python
class Solution:
    # @param A  a list of integers
    # @param m  an integer, length of A
    # @param B  a list of integers
    # @param n  an integer, length of B
    # @return nothing(void)
    def merge(self, A, m, B, n):
        k = m+n-1
        B.insert(0, 0)
        m -= 1
        while n != 0 and m != -1:
            if A[m] < B[n]:
                A[k] = B[n]
                n -= 1
            else:
                A[k] = A[m]
                m -= 1
            k -= 1
        while n != 0:
            A[k] = B[n]
            k -= 1
            n -= 1
```

### Refinement
