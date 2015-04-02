## [Convert Sorted Array to Binary Search Tree](https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/)

### Problem

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

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
    public TreeNode sortedArrayToBST(int[] num) {
        return buildBST(num, 0, num.length-1);
    }

    public TreeNode buildBST(int[] num, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start+end+1)/2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = buildBST(num, start, mid-1);
        root.right = buildBST(num, mid+1, end);
        return root;
    }
}
```

### Refinement
