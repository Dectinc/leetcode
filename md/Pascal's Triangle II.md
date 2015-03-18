## [Pascal's Triangle II](https://leetcode.com/problems/pascals-triangle-ii/)

### Problem

Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,

Return `[1,3,3,1]`.

__Note:__

Could you optimize your algorithm to use only O(k) extra space? 

### Solution


### Code

``` Python
class Solution:
    # @return a list of integers
    def getRow(self, rowIndex):
        rowIndex += 1
        last = [0] * rowIndex
        result = [0] * rowIndex
        for i in range(rowIndex):
            for j in range(1, i):
                result[j] = last[j] + last[j - 1]
            result[i] = 1
            last = result[:]
        return result
```

### Refinement
