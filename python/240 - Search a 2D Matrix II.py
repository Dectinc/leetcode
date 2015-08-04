# -*- coding: utf-8 -*-
# @filename 240 - Search a 2D Matrix II
# @author   v-shijch
# @date     2015-08-04 15:40 PM
class Solution:
    # @param {integer[][]} matrix
    # @param {integer} target
    # @return {boolean}
    def searchMatrix(self, matrix, target):
        m, n = len(matrix), len(matrix[0])
        if m + n == 0:
            return False
        return self.helper(matrix, target, 0, 0, m - 1, n - 1)

    def helper(self, matrix, target, lx, ly, rx, ry):
        if lx > rx or ly > ry:
            return False
        if lx < 0 or ly < 0 or rx == len(matrix) or ry == len(matrix[0]):
            return False
        if matrix[lx][ly] > target or matrix[rx][ry] < target:
            return False
        mx, my = (lx + rx) / 2, (ly + ry) / 2
        if matrix[mx][my] == target:
            return True
        elif matrix[mx][my] > target:
            return self.helper(matrix, target, lx, ly, mx - 1, my - 1) \
                   or self.helper(matrix, target, mx, ly, rx, my-1) \
                   or self.helper(matrix, target, lx, my, mx-1, ry)
        else:
            return self.helper(matrix, target, mx + 1, my + 1, rx, ry) \
                   or self.helper(matrix, target, mx + 1, ly, rx, my) \
                   or self.helper(matrix, target, lx, my + 1, mx, ry)


if __name__ == '__main__':
    sol = Solution()
    matrix, target = [
                         [1, 2, 3, 4, 5],
                         [6, 7, 8, 9, 10],
                         [11, 12, 13, 14, 15],
                         [16, 17, 18, 19, 20],
                         [21, 22, 23, 24, 25]
                     ], 5
    print sol.searchMatrix(matrix, target)
