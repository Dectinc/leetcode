#! /usr/bin/env python
# -*- coding: utf-8 -*-
# @filename  79 - Word Search
# @author   dectinc@icloud.com
# @date     2015-03-24 23:55

class Solution:
    def __init__(self):
        self.m = 0
        self.n = 0

    # @param board, a list of lists of 1 length string
    # @param word, a string
    # @return a boolean
    def exist(self, board, word):
        self.m = len(board)
        if self.m == 0:
            return False
        self.n = len(board[0])
        if len(word) > self.m * self.n:
            return False
        visited = {}
        for i in xrange(self.m):
            for j in xrange(self.n):
                if self.searched(board, i, j, word, visited):
                    return True
        return False

    def searched(self, board, x, y, word, visited, start=0):
        if start == len(word):
            return True
        if x < 0 or y < 0 or x == self.m or y == self.n or visited.get(
                (x, y)) or board[x][y] != word[start]:
            return False
        visited[(x, y)] = True
        start += 1
        res = self.searched(board, x + 1, y, word, visited, start) \
              or self.searched(board, x - 1, y, word, visited, start) \
              or self.searched(board, x, y - 1, word, visited, start) \
              or self.searched(board, x, y + 1, word, visited, start)
        visited[(x, y)] = False
        return res


if __name__ == '__main__':
    sol = Solution()
    board, word = ["a"], "ab"
    # board, word = ["ABCE", "SFCS", "ADEE"], "ABCES"
    print sol.exist(board, word)
    