# -*- coding: utf-8 -*-
# @filename 212 - Word Search II
# @author   v-shijch
# @date     2015-07-08 14:57 PM


class Node():
    def __init__(self):
        self.next = {}
        self.word = None


class Solution:
    def __init__(self):
        self.m = 0
        self.n = 0
        self.res = set()

    # @param {character[][]} board
    # @param {string[]} words
    # @return {string[]}
    def findWords(self, board, words):
        if len(words) == 0:
            return []
        root = Node()
        for word in words:
            p = root
            for c in word:
                if c not in p.next:
                    p.next[c] = Node()
                p = p.next[c]
            p.word = word
        self.m = len(board)
        if self.m == 0:
            return False
        self.n = len(board[0])

        visited = {}
        for i in xrange(self.m):
            for j in xrange(self.n):
                self.search(board, i, j, root, visited)
        return list(self.res)

    def search(self, board, x, y, tree, visited):
        if tree.word:
            self.res.add(tree.word)
        if x < 0 or y < 0 or x == self.m or y == self.n \
                or visited.get((x, y)) \
                or board[x][y] not in tree.next:
            return
        visited[(x, y)] = True
        nextNode = tree.next[board[x][y]]
        self.search(board, x + 1, y, nextNode, visited)
        self.search(board, x - 1, y, nextNode, visited)
        self.search(board, x, y + 1, nextNode, visited)
        self.search(board, x, y - 1, nextNode, visited)
        visited[(x, y)] = False


if __name__ == '__main__':
    sol = Solution()
    board, words = ["ab"], ["a","b"]
    print sol.findWords(board, words)