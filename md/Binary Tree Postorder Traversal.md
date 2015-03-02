## [Binary Tree Postorder Traversal](https://oj.leetcode.com/problems/binary-tree-postorder-traversal/)

### Problem

Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree `{1,#,2,3}`,

```
   1
    \
     2
    /
   3
```

return `[3,2,1]`.

Note: Recursive solution is trivial, could you do it iteratively?

### Solution

visited status of right child nodes should be recorded?

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
    def postorderTraversal(self, root):
        nodes = []
        traversal = []
        pointer = root
        while pointer is not None:
            pointer.visited = False
            nodes.append(pointer)
            if pointer.left is not None:
                pointer = pointer.left
            elif len(nodes) == 0:
                break
            else:
                try:
                    pointer = nodes.pop()
                    if pointer.visited:
                        traversal.append(pointer.val)
                        pointer = nodes.pop()
                    else:
                        while pointer.right is None or pointer.visited:
                            traversal.append(pointer.val)
                            pointer = nodes.pop()
                        pointer.visited = True
                        nodes.append(pointer)
                        pointer = pointer.right
                except:
                    break
        return traversal

```

### Refinement

- traverse the tree by the following order: root - right child - left child, the output the result reversely.
