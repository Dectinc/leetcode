## [Unique Binary Search Trees II](https://leetcode.com/problems/unique-binary-search-trees-ii/)

### Problem

Given n, generate all structurally unique __BST's__ (binary search trees) that store values 1...n.

For example,

Given n = 3, your program should return all 5 unique BST's shown below.
```
   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
```
### Solution


### Code

``` Python
class Solution:
    # @return a list of tree node
    def generateTrees(self, n):
        return self.generateTree([i+1 for i in xrange(n)])

    def generateTree(self, nums):
        if len(nums) == 0:
            return [None]
        if len(nums) == 1:
            return [TreeNode(nums[0])]
        result = []
        length = len(nums)
        for i in range(length):
            for left in self.generateTree(nums[:i]):
                for right in self.generateTree(nums[i+1:]):
                    node = TreeNode(nums[i])
                    node.left = left
                    node.right = right
                    result.append(node)
        return result
```

### Refinement
