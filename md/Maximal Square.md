## [Maximal Square](https://leetcode.com/problems/maximal-square/)

### Problem

Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.

For example, given the following matrix:
```
1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
```
Return 4.

### Solution


### Code

``` Python
class Solution(object):
    def maximalSquare(self, matrix):
        """
        :type matrix: List[List[str]]
        :rtype: int
        """
        if matrix is None or len(matrix) == 0 or len(matrix[0]) == 0:
            return 0
        curMax = 0
        m, n = len(matrix), len(matrix[0])
        s = [[0 for j in xrange(n+1)] for i in xrange(m+1)]
        for i in xrange(1, m+1):
            for j in xrange(1, n+1):
                if matrix[i-1][j-1] == "1":
                    s[i][j] = min(s[i-1][j-1], s[i-1][j], s[i][j-1]) + 1
                curMax = max(curMax, s[i][j])
        return curMax*curMax
```

### Refinement
