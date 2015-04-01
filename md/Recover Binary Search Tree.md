## [Recover Binary Search Tree](https://leetcode.com/problems/recover-binary-search-tree/)

### Problem

Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure. 

### Solution


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
    TreeNode firstNode = null;
    TreeNode secondNode = null;
    TreeNode preNode = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        inorderTraversal(root);
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }

    public void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        if (firstNode == null && preNode.val >= root.val) {
            firstNode = preNode;
        }
        if (firstNode != null && preNode.val >= root.val) {
            secondNode = root;
        }
        preNode = root;
        inorderTraversal(root.right);
    }
}
```

### Refinement
