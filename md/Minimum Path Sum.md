## [Minimum Path Sum](https://leetcode.com/problems/minimum-path-sum/)

### Problem

Given a _m_ x _n_ grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

__Note:__ You can only move either down or right at any point in time.

### Solution


### Code

``` Python
class Solution:
    # @param grid, a list of lists of integers
    # @return an integer
    def minPathSum(self, grid):
        m = len(grid)
        n = len(grid[0])
        sums = grid[0]
        for j in range(1, n):
            sums[j] += sums[j - 1]
        for i in range(1, m):
            sums[0] += grid[i][0]
            for j in range(1, n):
                sums[j] = min(sums[j - 1], sums[j]) + grid[i][j]
        return sums[-1]
```

### Refinement
