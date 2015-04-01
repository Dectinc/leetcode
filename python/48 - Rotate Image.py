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
        print matrix

if __name__ == '__main__':
    sol = Solution()
    matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]]
    # matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]]
    sol.rotate(matrix)