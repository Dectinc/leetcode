# -*- coding: utf-8 -*-
# @filename 59 - Spiral Matrix II
# @author   Dectinc
# @date     2015-03-22 21:26 PM


class Solution:
    # @return a list of lists of integer
    def generateMatrix(self, n):
        matrix = []
        if n < 1:
            return matrix
        matrix = [[0 for j in range(n)] for i in range(n)]
        num = 1
        i = 0
        j = n-1
        while i < j:
            length = j-i
            starts = [num, num+length, num+length*2, num+length*3]
            for k in range(0, length):
                matrix[i][i+k] = num+k
                matrix[i+k][j] = starts[1]+k
                matrix[j][j-k] = starts[2]+k
                matrix[j-k][i] = starts[3]+k
            num += 4*length
            i += 1
            j -= 1
        if i == j:
            matrix[i][j] = num
        return matrix

if __name__ == '__main__':
    sol = Solution()
    n = 5
    print sol.generateMatrix(n)
