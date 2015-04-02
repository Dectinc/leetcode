## [Construct Binary Tree from Preorder and Inorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/)

### Problem

Given preorder and inorder traversal of a tree, construct the binary tree.

### Solution

Trick: using a HashMap to storage the node index in inorder traversal.

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
    HashMap<Integer, Integer> indexMap = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = inorder.length;
        for (int i = 0; i < length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, preorder.length-1, 0, length-1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd && inStart > inEnd) {
            return null;
        }
        int rootValue = preorder[preStart];
        TreeNode curRoot = new TreeNode(rootValue);
        int rootIndex = indexMap.get(rootValue);
        curRoot.left = buildTree(preorder, inorder, preStart+1, preStart+rootIndex-inStart, inStart, rootIndex-1);
        curRoot.right = buildTree(preorder, inorder, preStart+rootIndex-inStart+1, preEnd, rootIndex+1, inEnd);
        return curRoot;
    }
}
```

### Refinement
