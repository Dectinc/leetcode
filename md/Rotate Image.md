## [Rotate Image](https://leetcode.com/problems/rotate-image/)

### Problem

You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?

### Solution


### Code

``` Python
class Solution:
    # @param matrix, a list of lists of integers
    # @return nothing (void), do not return anything, modify matrix in-place instead.
    def rotate(self, matrix):
        n = len(matrix)
        if n < 2:
            return
        i = 0
        j = n-1
        while i < j:
            for k in range(i, j):
                matrix[i][k], matrix[k][j], matrix[j][n-k-1], matrix[n-k-1][i] = matrix[n-k-1][i], matrix[i][k], matrix[k][j], matrix[j][n-k-1]
            i += 1
            j -= 1
```

### Refinement
