## [Unique Binary Search Trees](https://oj.leetcode.com/problems/unique-binary-search-trees/)

### Problem

Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

```
   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
```

### Solution

Two-lever interation

### Code

``` python
class Solution:
    # @return an integer
    def numTrees(self, n):
        number = 0
        if n < 0:
            return 0
        if n < 2:
            return 1
        if n == 2:
            return 2
        results = [1, 1, 2] + [0] * (n-2)
        for i in range(3, n+1):
            for j in range(i):
                results[i] += results[j] * results[i-j-1]
        return results[n]
```

### Refinement
