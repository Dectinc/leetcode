## [Binary Tree Level Order Traversal II](https://leetcode.com/problems/binary-tree-level-order-traversal-ii/)

### Problem

Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree `{3,9,20,#,#,15,7}`,
```
    3
   / \
  9  20
    /  \
   15   7
```
return its bottom-up level order traversal as:
```
[
  [15,7],
  [9,20],
  [3]
]
```

### Solution


### Code

``` Python
# Definition for a  binary tree node
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    # @param root, a tree node
    # @return a list of lists of integers
    def levelOrderBottom(self, root):
        res = []
        if not root:
            return []
        astack = [root]
        while len(astack) > 0:
            curLevel = []
            nextstack = []
            for i in range(len(astack)):
                node = astack[i]
                curLevel.append(node.val)
                if node.left:
                    nextstack.append(node.left)
                if node.right:
                    nextstack.append(node.right)
            res.insert(0, curLevel)
            astack = nextstack
        return res        
```

### Refinement
