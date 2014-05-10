## [Balanced Binary Tree](http://oj.leetcode.com/problems/balanced-binary-tree/)

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

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
    HashMap<TreeNode, Integer> depthMap = new HashMap<TreeNode, Integer>();
    
    public boolean isBalanced(TreeNode root) {
        if (root == null) { 
            return true;
        }
        return isBalanced(root.left) && isBalanced(root.right)
            && Math.abs(getDepth(root.left) - getDepth(root.right)) < 2;
    }
    
    private int getDepth(TreeNode root) {
        if (depthMap.containsKey(root)){
            return depthMap.get(root);
        }
        if (root == null) {
            return 0;
        }
        int depth = 1;
        if (root.left == null && root.right == null) {
            depth = depth + 1;
        }
        else if (root.left == null) {
            depth = getDepth(root.right) + 1;
        }
        else if (root.right == null) {
            depth = getDepth(root.left) + 1;
        }
        else {
            depth = Math.max(getDepth(root.left), getDepth(root.right)) + 1;
        }
        depthMap.put(root, depth);
        return depth;
    }
}
```