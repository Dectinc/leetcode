## [Validate Binary Search Tree](https://leetcode.com/problems/validate-binary-search-tree/)

### Problem

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

- The left subtree of a node contains only nodes with keys __less than__ the node's key.
- The right subtree of a node contains only nodes with keys __greater than__ the node's key.
- Both the left and right subtrees must also be binary search trees.

### Solution


### Code

``` Python
class Solution:
    # @param root, a tree node
    # @return a boolean
    def isValidBST(self, root, _min=None, _max=None):
        if root is None:
            return True
        validLeft = self.isValidBST(root.left, _min, root.val)
        validRight = self.isValidBST(root.right, root.val, _max)
        return validLeft and validRight \
               and (True if _min is None else root.val > _min) \
               and (True if _max is None else root.val < _max)
```

### Refinement
