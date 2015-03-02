## [Binary Tree Preorder Traversal](https://oj.leetcode.com/problems/binary-tree-preorder-traversal/)

### Problem

Given a binary tree, return the preorder traversal of its nodes' values.

For example:

Given binary tree `{1,#,2,3}`,

```
   1
    \
     2
    /
   3
```

return `[1,2,3]`.

### Solution

non-iterative version

stack

### Code

``` python
# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @return a list of integers
    def preorderTraversal(self, root):
        if root is None:
            return []
        nodes = []
        traversal = []
        pointer = root
        while pointer is not None:
            if pointer.right is not None:
                nodes.insert(0, pointer.right)
            traversal.append(pointer.val)
            if pointer.left is not None:
                pointer = pointer.left
            else:
                if len(nodes) == 0:
                    break
                pointer = nodes.pop(0)
        return traversal

```

### Refinement
