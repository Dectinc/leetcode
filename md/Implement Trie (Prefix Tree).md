## [Implement Trie (Prefix Tree)](https://leetcode.com/problems/implement-trie-prefix-tree/)

### Problem

Implement a trie with insert, search, and startsWith methods.

__Note:__

You may assume that all inputs are consist of lowercase letters `a-z`.

### Solution


### Code

``` Python
class TrieNode:
    # Initialize your data structure here.
    def __init__(self):
        self.next = {}
        self.end = False

class Trie:
    def __init__(self):
        self.root = TrieNode()

    # @param {string} word
    # @return {void}
    # Inserts a word into the trie.
    def insert(self, word):
        p = self.root
        for c in word:
            if c not in p.next:
                p.next[c] = TrieNode()
            p = p.next[c]
        p.end = True

    # @param {string} word
    # @return {boolean}
    # Returns if the word is in the trie.
    def search(self, word):
        p = self.root
        for c in word:
            if c not in p.next:
                return False
            p = p.next[c]
        return p.end

    # @param {string} prefix
    # @return {boolean}
    # Returns if there is any word in the trie
    # that starts with the given prefix.
    def startsWith(self, prefix):
        p = self.root
        for c in prefix:
            if c not in p.next:
                return False
            p = p.next[c]
        return True


# Your Trie object will be instantiated and called as such:
# trie = Trie()
# trie.insert("somestring")
# trie.search("key")
```

### Refinement
