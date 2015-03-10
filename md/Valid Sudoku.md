## [Valid Sudoku](https://leetcode.com/problems/valid-sudoku/)

### Problem

Determine if a Sudoku is valid, according to: [Sudoku Puzzles - The Rules](http://sudoku.com.au/TheRules.aspx).

The Sudoku board could be partially filled, where empty cells are filled with the character `'.'`.

![sudoku](../img/250px-Sudoku-by-L2G-20050714.svg.png)

### Solution


### Code

``` Python
class Solution:
    # @param board, a 9x9 2D array
    # @return a boolean
    def isValidSudoku(self, board):
        isValid = True
        for i in range(9):
            flag1 = [True] * 10
            flag2 = [True] * 10
            for j in range(9):
                c = board[i][j]
                if c != '.':
                    c = int(c)
                    if flag1[c]:
                        flag1[c] = False
                    else:
                        return False
                c = board[j][i]
                if c != '.':
                    c = int(c)
                    if flag2[c]:
                        flag2[c] = False
                    else:
                        return False
        for i in range(3):
            for j in range(3):
                flag = [True] * 10
                for m in range(3):
                    for n in range(3):
                        c = board[i*3+m][j*3+n]
                        if c != '.':
                            c = int(c)
                            if flag[c]:
                                flag[c] = False
                            else:
                                return False
        return True
```

### Refinement
