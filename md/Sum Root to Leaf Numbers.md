## [Sum Root to Leaf Numbers](https://leetcode.com/problems/sum-root-to-leaf-numbers/)

### Problem

Given a binary tree containing digits from `0-9` only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path `1->2->3` which represents the number `123`.

Find the total sum of all root-to-leaf numbers.

For example,
```
    1
   / \
  2   3
```
The root-to-leaf path `1->2` represents the number `12`.

The root-to-leaf path `1->3` represents the number `13`.

Return the sum = 12 + 13 = `25`. 

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
	public int sumNumbers(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int result = 0;
		Queue<TreeNode> nodes = new LinkedList<TreeNode>();
		nodes.add(root);

		while (!nodes.isEmpty()) {
			TreeNode node = nodes.poll();
			if (node.left == null && node.right == null) {
				result += node.val;
			}
			if (node.left != null) {
				node.left.val += node.val * 10;
				nodes.add(node.left);
			}
			if (node.right != null) {
				node.right.val += node.val * 10;
				nodes.add(node.right);
			}
		}

		return result;
	}
}
```

### Refinement
