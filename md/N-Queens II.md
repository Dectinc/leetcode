## [N-Queens II](https://oj.leetcode.com/problems/n-queens-ii/)

### Problem

Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.

![8-queens](../img/8-queens.png)

### Solution


### Code

``` python
class Solution:
    # @return an integer
    def initFlags(self, n):
        global flag_row
        global flag_column
        global flag_diagonal_45
        global flag_diagonal_135
        flag_row = [False] * n  # mark occupation of rows
        flag_column = [False] * n  # mark occupation of columns
        flag_diagonal_45 = [False] * (2 * n - 1)
        flag_diagonal_135 = [False] * (2 * n - 1)

    def isPositionValid(self, x, y, n):
        return not (flag_row[x] or flag_column[y]
                or flag_diagonal_45[x + y]
                or flag_diagonal_135[n - 1 - x + y])

    def togglePositionStatus(self, x, y, n):
        flag_row[x] = not flag_row[x]
        flag_column[y] = not flag_column[y]
        flag_diagonal_45[x + y] = not flag_diagonal_45[x + y]
        flag_diagonal_135[n - 1 - x + y] = not flag_diagonal_135[n - 1 - x + y]

    def place(self, n):
        x = len(self.pos)
        if x == n:
            self.count += 1
            return
        for y in range(n):
            if (self.isPositionValid(x, y, n)):
                self.pos.append(y)
                self.togglePositionStatus(x, y, n)
                self.place(n)
                self.pos.pop()
                self.togglePositionStatus(x, y, n)

    def totalNQueens(self, n):
        self.initFlags(n)
        self.count = 0
        self.pos = []
        self.place(n)
        return self.count
```

### Refinement
