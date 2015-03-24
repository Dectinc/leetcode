## [Set Matrix Zeroes](https://leetcode.com/problems/set-matrix-zeroes/)

### Problem

Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

__Follow up__:

Did you use extra space?

A straight forward solution using O(mn) space is probably a bad idea.

A simple improvement uses O(m + n) space, but still not the best solution.

Could you devise a constant space solution?

### Solution


### Code

``` Python
class Solution:
    # @param matrix, a list of lists of integers
    # @return nothing (void), do not return anything, MODIFY matrix IN PLACE.
    def setZeroes(self, matrix):
        rows = len(matrix)
        if rows == 0:
            return
        columns = len(matrix[0])
        todoRows = []
        todoColumns = []
        for i in xrange(rows):
            for j in xrange(columns):
                if matrix[i][j] == 0:
                    todoRows.append(i)
                    todoColumns.append(j)
        todoRows = set(todoRows)
        todoColumns = set(todoColumns)
        for row in todoRows:
            for j in xrange(columns):
                matrix[row][j] = 0
        for column in todoColumns:
            for j in xrange(rows):
                matrix[j][column] = 0
        return
```

- No type change. Using first 0 occurrence as the placeholder

``` Python
class Solution:
# @param matrix, a list of lists of integers
# RETURN NOTHING, MODIFY matrix IN PLACE.
def setZeroes(self, matrix):
    pilot = None
    m, n = len(matrix), len(matrix[0])
    for i in xrange(m):
        for j in xrange(n):
            if (matrix[i][j] == 0) and (pilot is None):
                pilot = (i, j)
            elif matrix[i][j] == 0:
                matrix[pilot[0]][j] = 0
                matrix[i][pilot[1]] = 0
    if pilot is None : return

    for i in xrange(m):
        if i == pilot[0] : continue
        for j in xrange(n):
            if j == pilot[1]: continue
            if matrix[i][pilot[1]] == 0 or matrix[pilot[0]][j] == 0:
                matrix[i][j] = 0

    for i in xrange(m):
        matrix[i][pilot[1]] = 0
    for j in xrange(n):
        matrix[pilot[0]][j] = 0
```

### Refinement
