# -*- coding: utf-8 -*-
# @filename 62 - Unique Paths
# @author   Dectinc
# @date     2015-03-22 23:08 PM


class Solution:
    # @return an integer
    def uniquePaths(self, m, n):
        counts = [[0] * n for j in range(m)]
        counts[0][0] = 1
        for i in range(m):
            for j in range(n):
                tmp = counts[i][j]
                if i > 0:
                    tmp += counts[i - 1][j]
                if j > 0:
                    tmp += counts[i][j - 1]
                counts[i][j] = tmp
        return counts[m - 1][n - 1]


if __name__ == '__main__':
    sol = Solution()
    m, n = 1, 10
    print sol.uniquePaths(m, n)