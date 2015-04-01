#! /usr/bin/env python
# -*- coding: utf-8 -*-
# @filename  64 - Minimum Path Sum
# @author   dectinc@icloud.com
# @date     2015-03-23 00:40

class Solution:
    # @param grid, a list of lists of integers
    # @return an integer
    def minPathSum(self, grid):
        m = len(grid)
        n = len(grid[0])
        sums = grid[0]
        for j in range(1, n):
            sums[j] += sums[j - 1]
        for i in range(1, m):
            sums[0] += grid[i][0]
            for j in range(1, n):
                sums[j] = min(sums[j - 1], sums[j]) + grid[i][j]
        return sums[-1]


if __name__ == '__main__':
    sol = Solution()
    grid = [[1, 2], [1, 1]]
    print sol.minPathSum(grid)