## [Search a 2D Matrix II](https://leetcode.com/problems/search-a-2d-matrix-ii/)

### Problem

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

- Integers in each row are sorted in ascending from left to right.
- Integers in each column are sorted in ascending from top to bottom.

For example,

Consider the following matrix:
```
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
```
Given __target__ = `5`, return `true`.

Given __target__ = `20`, return `false`.

### Solution


### Code

``` Python
class Solution:
    # @param {integer[][]} matrix
    # @param {integer} target
    # @return {boolean}
    def searchMatrix(self, matrix, target):
        m, n = len(matrix), len(matrix[0])
        if m + n == 0:
            return False
        return self.helper(matrix, target, 0, 0, m - 1, n - 1)

    def helper(self, matrix, target, lx, ly, rx, ry):
        if lx > rx or ly > ry:
            return False
        if lx < 0 or ly < 0 or rx == len(matrix) or ry == len(matrix[0]):
            return False
        if matrix[lx][ly] > target or matrix[rx][ry] < target:
            return False
        mx, my = (lx + rx) / 2, (ly + ry) / 2
        if matrix[mx][my] == target:
            return True
        elif matrix[mx][my] > target:
            return self.helper(matrix, target, lx, ly, mx - 1, my - 1) \
                   or self.helper(matrix, target, mx, ly, rx, my-1) \
                   or self.helper(matrix, target, lx, my, mx-1, ry)
        else:
            return self.helper(matrix, target, mx + 1, my + 1, rx, ry) \
                   or self.helper(matrix, target, mx + 1, ly, rx, my) \
                   or self.helper(matrix, target, lx, my + 1, mx, ry)
```

### Refinement
