#! /usr/bin/env python
# -*- coding: utf-8 -*-
# @filename  85 - Maximal Rectangle
# @author   dectinc@icloud.com
# @date     2015-03-18 23:40

class Solution:
    # @param matrix, a list of lists of 1 length string
    # @return an integer
    def maximalRectangle(self, matrix):
        if not matrix or len(matrix) == 0:
            return 0
        result = 0
        m, n = len(matrix), len(matrix[0])
        left, right, height = [0]*n, [0]*n, [0]*n
        for i in xrange(m):
            curLeft, curRight = 0, n
            for j in xrange(n):
                if matrix[i][j] == '1':
                    height[j] += 1
                    left[j] = max(left[j], curLeft)
                else:
                    height[j] = 0
                    left[j], curLeft = 0, j+1
            for j in xrange(n-1, -1, -1):
                if matrix[i][j] == '1':
                    right[j] = min(right[j], curRight)
                else:
                    right[j], curRight = n, j
            for j in xrange(n):
                result = max(result, (right[j]-left[j])*height[j])
        return result




if __name__ == '__main__':
    sol = Solution()
    matrix = [1,1]
    print sol.maximalRectangle(matrix)