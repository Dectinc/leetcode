## [Symmetric Tree](http://oj.leetcode.com/problems/symmetric-tree/)

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

```
    1
   / \
  2   2
 / \ / \
3  4 4  3
```

But the following is not:

```
    1
   / \
  2   2
   \   \
   3    3
```

**Note:**

Bonus points if you could solve it both recursively and iteratively.

confused what `"{1,#,2,3}"` means? 

**OJ's Binary Tree Serialization:**

The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

Here's an example:

```
   1
  / \
 2   3
    /
   4
    \
     5
```

The above binary tree is serialized as `"{1,2,3,#,#,4,#,#,5}"`.

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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return compare(root.left, root.right);
    }
    
    private boolean compare(TreeNode ta, TreeNode tb) {
        if (ta == null && tb == null) {
            return true;
        } else if (ta == null || tb == null) {
            return false;
        } else if (ta.val != tb.val) {
            return false;
        }
        return compare(ta.left, tb.right) && compare(ta.right, tb.left);
    }
}
```