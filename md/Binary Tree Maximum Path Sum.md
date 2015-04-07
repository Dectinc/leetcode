## [Binary Tree Maximum Path Sum](https://leetcode.com/problems/binary-tree-maximum-path-sum/)

### Problem

Given a binary tree, find the maximum path sum.

The path may start and end at any node in the tree.

For example:

Given the below binary tree,
```
       1
      / \
     2   3
```
Return `6`.

### Solution

- mind using static field on OJ

### Code

``` Java
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
    private int max = -2147483648;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        maxPathToLeaf(root);
        return max;
    }

    private int maxPathToLeaf(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int maxLeft = maxPathToLeaf(root.left);
        maxLeft = maxLeft < 0 ? 0 : maxLeft;
        int maxRight = maxPathToLeaf(root.right);
        maxRight = maxRight < 0 ? 0 : maxRight;
        if (root.val + maxLeft + maxRight > max) {
            max = root.val + maxLeft + maxRight;
        }
        root.val += Math.max(maxLeft, maxRight);
        return root.val;
    }
}
```

### Refinement
