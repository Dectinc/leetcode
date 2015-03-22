## [Unique Paths](https://leetcode.com/problems/unique-paths/)

### Problem

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?

![](robot_maze.png)

Above is a 3 x 7 grid. How many possible unique paths are there?

__Note:__ m and n will be at most 100.

### Solution


### Code

``` Python
class Solution:
    # @return an integer
    def uniquePaths(self, m, n):
        counts = [[0] * n for j in range(m)]
        counts[0][0] = 1
        for i in range(m):
            for j in range(n):
                tmp = counts[i][j]
                if i > 0:
                    tmp += counts[i - 1][j]
                if j > 0:
                    tmp += counts[i][j - 1]
                counts[i][j] = tmp
        return counts[m - 1][n - 1]
```

### Refinement
