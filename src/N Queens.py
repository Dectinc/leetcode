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
                    # print self.pos
                if len(self.pos) == 0:
                    print self.solutions
                    return self.solutions
                lastY = self.pos.pop()
                self.togglePositionStatus(x-1, lastY, n)
                y = lastY + 1
        # print self.solutions


if __name__ == '__main__':
    solution = Solution()
    solution.solveNQueens(6)
