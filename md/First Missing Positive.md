## [First Missing Positive](https://leetcode.com/problems/first-missing-positive/)

### Problem

Given an unsorted integer array, find the first missing positive integer.

For example,

Given `[1,2,0]` return `3`,

and `[3,4,-1,1]` return `2`.

Your algorithm should run in O(n) time and uses constant space.

### Solution


### Code

- O(n) time and O(n) space

``` Python
class Solution:
    # @param A, a list of integers
    # @return an integer
    def firstMissingPositive(self, A):
        if not A or len(A) == 0:
            return 1
        length = len(A)+1
        B = [True] * length
        for a in A:
            if a > 0 and a < length:
                B[a] = False
        for i in range(1, length):
            if B[i]:
                return i
        return length
```

- O(n) time and O(1) space
The basic idea is to set A[i] = i+1 to indicate number i+1 is in the array. Then check the first i that does not meet A[i] = i+1 (which means i+1 is missing). Zeros and negative ones are skipped.

``` Python
class Solution:
    # @param A, a list of integers
    # @return an integer
    def firstMissingPositive(self, A):
        if not A or len(A) == 0:
            return 1
        i = 0
        length = len(A)+1
        while i < len(A):
            a = A[i]
            if a > 0 and a < length and a != i+1 and A[a-1] != A[i]:
                A[i], A[a-1] = A[a-1], A[i]
            else:
                i += 1
        for i,a in enumerate(A):
            if a != i+1:
                return i+1
        return length
```

### Refinement
