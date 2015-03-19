## [Jump Game](https://leetcode.com/problems/jump-game/)

### Problem

 Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = `[2,3,1,1,4]`, return `true`.

A = `[3,2,1,0,4]`, return `false`. 

### Solution


### Code

- TLE: recursive

``` Python
class Solution:
    # @param A, a list of integers
    # @return a boolean
    def canJump(self, A):
        if not A or len(A) == 0:
            return True
        for i in range(1, A[0]+1):
            if self.canJump(A[i:]):
                return True
        return False
```

- Mark the margin current node can reach

``` Python
class Solution:
    # @param A, a list of integers
    # @return a boolean
    def canJump(self, A):
        if not A or len(A) < 2:
            return True
        canReach = A[0]
        for i in range(1, len(A)):
            if canReach < i:
                return False
            if i + A[i] > canReach:
                canReach = i + A[i]
        return True
```

### Refinement
