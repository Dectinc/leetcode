free_col = [[True for j in range(10)] for i in range(9)]
free_row = [[True for j in range(10)] for i in range(9)]
free_box = [[True for j in range(10)] for i in range(9)]

class Solution:
    def getBoxIndex(self, x, y):
        return 3*(y/3)+x/3

    def togglePosition(self, x, y, num):
        free_col[x][num] = not free_col[x][num]
        free_row[y][num] = not free_row[y][num]
        z = self.getBoxIndex(x, y)
        free_box[z][num] = not free_box[z][num]

    def isPositionValid(self, x, y, num):
        return free_col[x][num] and free_row[y][num] and free_box[self.getBoxIndex(x, y)][num]

    def solveSudokuRecursive(self, board, pos=0):
        if pos < 0 or pos > 80:
            return True
        x = pos / 9
        y = pos % 9
        if board[x][y] != '.':
            return self.solveSudokuRecursive(board, pos + 1)
        else:
            for num in range(1, 10):
                if self.isPositionValid(x, y, num):
                    self.togglePosition(x, y, num)
                    self.putNumberInPosition(x, y, num, board)
                    if self.solveSudokuRecursive(board, pos+1):
                        return True
                    else:
                        self.togglePosition(x, y, num)
                        self.putNumberInPosition(x, y, '.', board)
            return False

    # @param board, a 9x9 2D array
    # Solve the Sudoku by modifying the input board in-place.
    # Do not return any value.
    def solveSudoku(self, board):
        for i in range(9):
            for j in range(9):
                num = board[i][j]
                if num != '.':
                    self.togglePosition(i, j, int(num))
        self.solveSudokuRecursive(board)

    def putNumberInPosition(self, x, y, num, board):
        board[x] = board[x][:y] + [str(num)] + board[x][y+1:]


if __name__ == '__main__':
    sol = Solution()
    board = ["53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1",
             "7...2...6", ".6....28.", "...419..5", "....8..79"]
    sol.solveSudoku(board)
    print board
    # print sol.getBoxIndex(8, 8)
    # for i in range(9):
    #     for j in range(9):
    #         print sol.getBoxIndex(i, j)
