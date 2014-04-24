## [Maximum Depth of Binary Tree](http://oj.leetcode.com/problems/maximum-depth-of-binary-tree/)

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        else if (root.left == null && root.right == null) {
            return 1;
        }
        
        int left_depth = 0;
        int right_depth = 0;
        int depth = 0;
        if (root.left != null && root.right != null) {
            left_depth = maxDepth(root.left);
            right_depth = maxDepth(root.right);
            depth = left_depth > right_depth ? left_depth : right_depth;
        }
        else if (root.left == null && root.right != null) {
            depth = maxDepth(root.right);
        }
        else if (root.left != null && root.right == null) {
            depth = maxDepth(root.left);
        }
        return depth+1;
    }
}
```