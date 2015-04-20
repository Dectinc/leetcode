## [Binary Tree Right Side View](https://leetcode.com/problems/binary-tree-right-side-view/)

### Problem

Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:

Given the following binary tree,
```
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
```
You should return `[1, 3, 4]`.

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
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> result = new LinkedList<Integer>();
		if (root == null) {
			return result;
		}
		TreeNode node = root;
		Queue<TreeNode> stack = new LinkedList<TreeNode>();
		Queue<TreeNode> next = new LinkedList<TreeNode>();
		stack.add(node);
		while (!stack.isEmpty()) {
			while (!stack.isEmpty()) {
				node = stack.poll();
				if (node.left != null) {
					next.add(node.left);
				}
				if (node.right != null) {
					next.add(node.right);
				}
			}
			result.add(node.val);
			stack = next;
			next = new LinkedList<TreeNode>();
		}
		return result;
	}
}
```

```
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }

    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }

        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);

    }
}
```

### Refinement
