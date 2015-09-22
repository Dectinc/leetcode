## [Count Complete Tree Nodes](https://leetcode.com/problems/count-complete-tree-nodes/)

### Problem

Given a complete binary tree, count the number of nodes.

__Definition of a complete binary tree from [Wikipedia](http://en.wikipedia.org/wiki/Binary_tree#Types_of_binary_trees)__:

In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

### Solution


### Code

``` Python
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def countNodes(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if root is None:
            return 0
        l, r = self.leftHeight(root), self.rightHeight(root)
        if l == r:
            return 2**l - 1
        ll, lr = self.leftHeight(root.left), self.rightHeight(root.left)
        if ll == lr:
            return 2**ll + self.countNodes(root.right)
        rl, rr = self.leftHeight(root.right), self.rightHeight(root.right)
        return 2**rr + self.countNodes(root.left)
        
    def leftHeight(self, root):
        l, p = 0, root
        while p is not None:
            l += 1
            p = p.left
        return l
        
    def rightHeight(self, root):
        r, p = 0, root
        while p is not None:
            r += 1
            p = p.right
        return r
```

### Refinement
