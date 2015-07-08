## [Add and Search Word - Data structure design](https://leetcode.com/problems/add-and-search-word-data-structure-design/)

### Problem

Design a data structure that supports the following two operations:
```
void addWord(word)
bool search(word)
```
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

For example:
```
addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true
```
### Solution


### Code

``` Python
class Node:
    def __init__(self):
        self.next = {}
        self.all = []
        self.end = False

class WordDictionary:
    # initialize your data structure here.
    def __init__(self):
        self.root = Node()


    # @param {string} word
    # @return {void}
    # Adds a word into the data structure.
    def addWord(self, word):
        p = self.root
        for c in word:
            if c not in p.next:
                p.next[c] = Node()
                p.all.append(p.next[c])
            p = p.next[c]
        p.end = True

    # @param {string} word
    # @return {boolean}
    # Returns if the word is in the data structure. A word could
    # contain the dot character '.' to represent any one letter.
    def search(self, word):
        return WordDictionary.searchNode(self.root, word)

    @staticmethod
    def searchNode(node, word):
        if len(word) == 0:
            return node.end
        c = word[0]
        if c == '.':
            for _n in node.all:
                if WordDictionary.searchNode(_n, word[1:]):
                    return True
            return False
        elif c not in node.next:
            return False
        else:
            return WordDictionary.searchNode(node.next[c], word[1:])


# Your WordDictionary object will be instantiated and called as such:
# wordDictionary = WordDictionary()
# wordDictionary.addWord("word")
# wordDictionary.search("pattern")
```

### Refinement
