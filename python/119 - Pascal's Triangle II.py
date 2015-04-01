#! /usr/bin/env python
# -*- coding: utf-8 -*-
# @filename  119 - Pascal's Triangle II
# @author   dectinc@icloud.com
# @date     2015-03-18 23:40

class Solution:
    # @return a list of integers
    def getRow(self, rowIndex):
        rowIndex += 1
        last = [0] * rowIndex
        result = [0] * rowIndex
        for i in range(rowIndex):
            for j in range(1, i):
                result[j] = last[j] + last[j - 1]
            result[i] = 1
            last = result[:]
        return result


if __name__ == '__main__':
    sol = Solution()
    print sol.getRow(2)