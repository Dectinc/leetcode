## [Search a 2D Matrix](https://leetcode.com/problems/search-a-2d-matrix/)

### Problem

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

- Integers in each row are sorted from left to right.
- The first integer of each row is greater than the last integer of the previous row.

For example,

Consider the following matrix:
```
[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
```
Given target = `3`, return `true`.

### Solution

Treat the matrix as a sorted list.

### Code

``` Python
class Solution:
    # @param matrix, a list of lists of integers
    # @param target, an integer
    # @return a boolean
    def searchMatrix(self, matrix, target):
        m = len(matrix)
        if m == 0:
            return False
        n = len(matrix[0])
        start = 0
        end = m*n - 1
        while start <= end:
            mid = (start+end)/2
            row = mid/n
            column = mid%n
            num = matrix[row][column]
            if num == target:
                return True
            elif num < target:
                start = mid+1
            else:
                end = mid-1
        return False
```

### Refinement
