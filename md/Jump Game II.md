## [Jump Game II](https://leetcode.com/problems/jump-game-ii/)

### Problem

Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = `[2,3,1,1,4]`

The minimum number of jumps to reach the last index is `2`. (Jump `1` step from index 0 to 1, then `3` steps to the last index.) 

### Solution


### Code

``` Python
class Solution:
    # @param A, a list of integers
    # @return an integer
    def jump(self, A):
        jumps = 0
        start = end = max_reach = 0
        while max_reach < len(A) - 1:
            for i in range(start, end + 1):
                max_reach = max(max_reach, i + A[i])
            start, end = end + 1, max_reach
            jumps += 1
        return jumps
```

### Refinement
