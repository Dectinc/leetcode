package cc.dectinc.leetcode;

import cc.dectinc.leetcode.structs.TreeNode;

public class MaximumDepthofBinaryTree {
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		} else if (root.left == null && root.right == null) {
			return 1;
		}
		int left_depth = 0;
		int right_depth = 0;
		int depth = 0;
		if (root.left != null && root.right != null) {
			left_depth = maxDepth(root.left);
			right_depth = maxDepth(root.right);
			depth = left_depth > right_depth ? left_depth : right_depth;
		} else if (root.left == null && root.right != null) {
			depth = maxDepth(root.right);
		} else if (root.left != null && root.right == null) {
			depth = maxDepth(root.left);
		}
		return depth + 1;
	}
}