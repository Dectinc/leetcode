## [Binary Tree Zigzag Level Order Traversal](https://oj.leetcode.com/problems/binary-tree-zigzag-level-order-traversal/)

### Problem

Given a binary tree, return the *zigzag level order* traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:

Given binary tree `{3,9,20,#,#,15,7}`,

```
    3
   / \
  9  20
    /  \
   15   7
```

return its zigzag level order traversal as:

```
[
  [3],
  [20,9],
  [15,7]
]
```


### Solution

Get the BFS traversal of the tree according to layer, reverse the list of given layers.

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
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (root == null) {
			return res;
		}
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int num;
		boolean reverse = false;
		while (!queue.isEmpty()) {
			num = queue.size();
			tmp.clear();
			for (int i = 0; i < num; i++) {
				TreeNode node = queue.poll();
				tmp.add(node.val);
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			if (reverse) {
				Collections.reverse(tmp);
				reverse = false;
			} else {
				reverse = true;
			}
			res.add(new ArrayList<Integer>(tmp));
		}
		return res;
	}
}
```

### Refinement