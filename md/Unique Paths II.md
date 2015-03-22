## [Unique Paths II](https://leetcode.com/problems/unique-paths-ii/)

### Problem

Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as `1` and `0` respectively in the grid.

For example,

There is one obstacle in the middle of a 3x3 grid as illustrated below.
```
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
```
The total number of unique paths is `2`.

__Note:__ _m_ and _n_ will be at most 100.

### Solution


### Code

``` Python
class Solution:
    # @param obstacleGrid, a list of lists of integers
    # @return an integer
    def uniquePathsWithObstacles(self, obstacleGrid):
        m = len(obstacleGrid)
        if m < 1:
            return 0
        n = len(obstacleGrid[0])
        if m == 1 and n == 1 and obstacleGrid[0][0] == 0:
            return 1
        counts = [[0]*n for i in range(m)]
        i = 0
        while i < m and obstacleGrid[i][0] == 0:
            counts[i][0] = 1
            i += 1
        if obstacleGrid[0][0] == 0:
            i = 1
        else:
            i = n
        while i < n and obstacleGrid[0][i] == 0:
            counts[0][i] = 1
            i += 1
        for i in range(1, m):
            for j in range(1, n):
                if obstacleGrid[i][j] == 1:
                    counts[i][j] = 0
                else:
                    counts[i][j] += counts[i-1][j] + counts[i][j-1]
        return counts[m-1][n-1]
        
```

### Refinement
