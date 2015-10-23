## [Kth Smallest Element in a BST](https://leetcode.com/problems/kth-smallest-element-in-a-bst/)

### Problem

Given a binary search tree, write a function `kthSmallest` to find the kth smallest element in it.

__Note__:

You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

__Follow up__:

What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would you optimize the kthSmallest routine?

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
    def kthSmallest(self, root, k):
        """
        :type root: TreeNode
        :type k: int
        :rtype: int
        """
        p, nodes = root, []
        while p is not None:
            nodes.append(p)
            p = p.left
        i = 0
        while i < k and nodes:
            q = nodes.pop()
            i += 1
            if i == k:
                return q.val
            p = q.right
            while p is not None:
                nodes.append(p)
                p = p.left
```

### Refinement
