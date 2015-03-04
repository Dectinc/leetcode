## [N-Queens](https://oj.leetcode.com/problems/n-queens/)

### Problem

The _n_-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

![8-queens](../img/8-queens.png)

Given an integer _n_, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:
```
[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
```

### Solution

backtracking

### Code

- Recursion version in python

``` python
class Solution:
    # @return a list of lists of string
    def initFlags(self, n):
        global flag_row
        global flag_column
        global flag_diagonal_45
        global flag_diagonal_135
        flag_row = [False] * n  # mark occupation of rows
        flag_column = [False] * n  # mark occupation of columns
        flag_diagonal_45 = [False] * (2 * n - 1)
        flag_diagonal_135 = [False] * (2 * n - 1)

    def appendSolution(self, location):
        n = len(location)
        solution = []
        for pos in location:
            solution.append('.' * (pos) + 'Q' + '.' * (n - pos - 1))
        self.solutions.append(solution)

    def isPositionValid(self, x, y, n):
        flag = False
        try:
            flag =  not (flag_row[x] or flag_column[y]
                    or flag_diagonal_45[x + y]
                    or flag_diagonal_135[n - 1 - x + y])
        except:
            print x, y, n
        return flag

    def togglePositionStatus(self, x, y, n):
        flag_row[x] = not flag_row[x]
        flag_column[y] = not flag_column[y]
        flag_diagonal_45[x + y] = not flag_diagonal_45[x + y]
        flag_diagonal_135[n - 1 - x + y] = not flag_diagonal_135[n - 1 - x + y]

    def place(self, n):
        x = len(self.pos)
        if x == n:
            self.appendSolution(self.pos)
            return
        for y in range(n):
            if (self.isPositionValid(x, y, n)):
                self.pos.append(y)
                self.togglePositionStatus(x, y, n)
                self.place(n)
                self.pos.pop()
                self.togglePositionStatus(x, y, n)

    def solveNQueens(self, n):
        self.initFlags(n)
        self.solutions = []
        self.pos = []
        # self.place(n)
        self.pos.append(0)
        lastY = -1
        y = 0
        while len(self.pos) > 0:
            x = len(self.pos)
            for y in range(lastY+1, n):
                if (self.isPositionValid(x, y, n)):
                    self.pos.append(y)
                    self.togglePositionStatus(x, y, n)
                    lastY = -1
                    break
            if x == n:
                self.appendSolution(self.pos)
            lastY = self.pos.pop()
            self.togglePositionStatus(x-1, lastY, n)
        return self.solutions
```

- Recursion version in c++

``` cpp
class Solution {
private:
    bool *row, *column, *diagonal, *r_diagonal;
    int *solution;

public:
    void init(int n) {
        row = new bool[n];
        memset(row, true, sizeof(bool) * n);
        column = new bool[n];
        memset(column, true, sizeof(bool) * n);
        diagonal = new bool[n * 2];
        memset(diagonal, true, sizeof(bool) * n * 2);
        r_diagonal = new bool[n * 2];
        memset(r_diagonal, true, sizeof(bool) * n * 2);
        solution = new int[n];
    }

    void del() {
        delete [] row;
        delete [] column;
        delete [] diagonal;
        delete [] r_diagonal;
        delete [] solution;
    }

    void transferToStrings(int n, vector<vector<string> > &boards) {
        vector<string> ans;
        for (int i = 0; i < n; i++) {
            string s = "";
            for (int j = 0; j < n; j++) {
                s += solution[i] == j ? 'Q' : '.';
            }
            ans.push_back(s);
        }
        boards.push_back(ans);
    }

    void search(int n, int num, vector<vector<string> > &boards) {
        if (num == n) {
            transferToStrings(n, boards);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (row[i] && column[i] && diagonal[i + num] && r_diagonal[i - num + n]) {
                row[i] = false;
                column[i] = false;
                diagonal[i + num]  = false;
                r_diagonal[i - num + n] = false;
                solution[num] = i;

                search(n, num + 1, boards);

                row[i] = true;
                column[i] = true;
                diagonal[i + num]  = true;
                r_diagonal[i - num + n] = true;
            }
        }
    }

    vector<vector<string> > solveNQueens(int n) {
        // Start typing your C/C++ solution below
        // DO NOT write int main() function
        init(n);
        vector<vector<string> > boards;
        search(n, 0, boards);
        del();
        return boards;
    }
};
```

- Non-recursion version in python

``` python
class Solution:
    # @return a list of lists of string
    def initFlags(self, n):
        global flag_row
        global flag_column
        global flag_diagonal_45
        global flag_diagonal_135
        flag_row = [False] * n  # mark occupation of rows
        flag_column = [False] * n  # mark occupation of columns
        flag_diagonal_45 = [False] * (2 * n - 1)
        flag_diagonal_135 = [False] * (2 * n - 1)

    def appendSolution(self, location):
        n = len(location)
        solution = []
        for pos in location:
            solution.append('.' * (pos) + 'Q' + '.' * (n - pos - 1))
        self.solutions.append(solution)

    def isPositionValid(self, x, y, n):
        return not (flag_row[x] or flag_column[y]
                or flag_diagonal_45[x + y]
                or flag_diagonal_135[n - 1 - x + y])

    def togglePositionStatus(self, x, y, n):
        flag_row[x] = not flag_row[x]
        flag_column[y] = not flag_column[y]
        flag_diagonal_45[x + y] = not flag_diagonal_45[x + y]
        flag_diagonal_135[n - 1 - x + y] = not flag_diagonal_135[n - 1 - x + y]

    def solveNQueens(self, n):
        self.initFlags(n)
        self.solutions = []
        self.pos = []
        # self.place(n)
        y = 0
        while True:
            x = len(self.pos)
            while y < n and x < n:
                if (self.isPositionValid(x, y, n)):
                    self.pos.append(y)
                    self.togglePositionStatus(x, y, n)
                    y = 0
                    break
                y += 1
            if y == n or x == n:
                if x == n:
                    self.appendSolution(self.pos)
                if len(self.pos) == 0:
                    return self.solutions
                lastY = self.pos.pop()
                self.togglePositionStatus(x-1, lastY, n)
                y = lastY + 1
```

### Refinement
