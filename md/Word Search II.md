## [Word Search II](https://leetcode.com/problems/word-search-ii/)

### Problem

Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

For example,

Given __words__ = ["oath","pea","eat","rain"] and __board__ =
```
[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
```
Return `["eat","oath"]`.

__hint:__

You would need to optimize your backtracking to pass the larger test. Could you stop backtracking earlier?

If the current candidate does not exist in all words' prefix, you could stop backtracking immediately. What kind of data structure could answer such query efficiently? Does a hash table work? Why or why not? How about a Trie? If you would like to learn how to implement a basic trie, please work on this problem: [Implement Trie (Prefix Tree)](https://leetcode.com/problems/implement-trie-prefix-tree/) first.

### Solution


### Code

``` Python
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
```

### Refinement
