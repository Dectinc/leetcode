#! /usr/bin/env python
# -*- coding: utf-8 -*-
# @filename  55 - Jump Game
# @author   dectinc@icloud.com
# @date     2015-03-19 15:58

class Solution:
    # @param A, a list of integers
    # @return a boolean
    def canJump(self, A):
        if not A or len(A) < 2:
            return True
        canReach = A[0]
        for i in range(1, len(A)):
            if canReach < i:
                return False
            if i + A[i] > canReach:
                canReach = canReach + A[i]
        return True


if __name__ == '__main__':
    sol = Solution()
    # A = [2, 3, 1, 1, 4]
    A = [2, 1, 0, 0]
    # A = [1, 2, 2, 6, 3, 6, 1, 8, 9, 4, 7, 6, 5, 6, 8, 2, 6, 1, 3, 6, 6, 6, 3, 2,
    #      4, 9, 4, 5, 9, 8, 2, 2, 1, 6, 1, 6, 2, 2, 6, 1, 8, 6, 8, 3, 2, 8, 5, 8,
    #      0, 1, 4, 8, 7, 9, 0, 3, 9, 4, 8, 0, 2, 2, 5, 5, 8, 6, 3, 1, 0, 2, 4, 9,
    #      8, 4, 4, 2, 3, 2, 2, 5, 5, 9, 3, 2, 8, 5, 8, 9, 1, 6, 2, 5, 9, 9, 3, 9,
    #      7, 6, 0, 7, 8, 7, 8, 8, 3, 5, 0]
    print sol.canJump(A)