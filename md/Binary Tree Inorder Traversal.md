## [Binary Tree Inorder Traversal](https://oj.leetcode.com/problems/binary-tree-inorder-traversal/)

### Problem

Given a binary tree, return the inorder traversal of its nodes' values.

For example:

Given binary tree `{1,#,2,3}`,

```
   1
    \
     2
    /
   3
```

return `[1,3,2]`.

__Note:__ Recursive solution is trivial, could you do it iteratively?

### Solution


### Code

``` java
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == null) {
            return list;
        }
        list.addAll(inorderTraversal(root.left));
        list.add(root.val);
        list.addAll(inorderTraversal(root.right));
        return list;
    }
}
```

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
    def inorderTraversal(self, root):
        if root is None:
            return []
        nodes = []
        traversal = []
        pointer = root
        while pointer is not None:
            nodes.append(pointer)
            if pointer.left is not None:
                pointer = pointer.left
            else:
                try:
                    pointer = nodes.pop()
                    traversal.append(pointer.val)
                    while pointer.right is None:
                        pointer = nodes.pop()
                        traversal.append(pointer.val)
                    pointer = pointer.right
                except:
                    break
        return traversal
```

### Refinement
