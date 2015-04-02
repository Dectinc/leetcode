## [Construct Binary Tree from Inorder and Postorder Traversal](https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/)

### Problem

Given inorder and postorder traversal of a tree, construct the binary tree.

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
    HashMap<Integer, Integer> indexMap = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int length = inorder.length;
        for (int i = 0; i < length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(inorder, postorder, 0, length-1, 0, postorder.length-1);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        int rootValue = postorder[postEnd];
        TreeNode curRoot = new TreeNode(rootValue);
        int rootIndex = indexMap.get(rootValue);
        curRoot.left = buildTree(inorder, postorder, inStart, rootIndex-1, postStart, postStart+rootIndex-inStart-1);
        curRoot.right = buildTree(inorder, postorder, rootIndex+1, inEnd, postStart+rootIndex-inStart, postEnd-1);
        return curRoot;
    }
}
```

### Refinement
