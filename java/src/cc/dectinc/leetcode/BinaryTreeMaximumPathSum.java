/**
 * 
 */

package cc.dectinc.leetcode;

import cc.dectinc.api.structs.TreeNode;

/**
 * @author chenshijiang
 * @date Apr 6, 2015 5:26:57 PM
 * 
 */
public class BinaryTreeMaximumPathSum {
	private static int max = -2147483648;

	public int maxPathSum(TreeNode root) {
		if (root == null) {
			return 0;
		}
		maxPathToLeaf(root);
		return max;
	}

	private int maxPathToLeaf(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int maxLeft = maxPathToLeaf(root.left);
		maxLeft = maxLeft < 0 ? 0 : maxLeft;
		int maxRight = maxPathToLeaf(root.right);
		maxRight = maxRight < 0 ? 0 : maxRight;
		if (root.val + maxLeft + maxRight > max) {
			max = root.val + maxLeft + maxRight;
		}
		root.val += Math.max(maxLeft, maxRight);
		return root.val;
	}

	public static void main(String[] args) {
		BinaryTreeMaximumPathSum sol = new BinaryTreeMaximumPathSum();
		TreeNode root = TreeNode.constructTreeWithLevelTraversal(new Integer[] { -3 });
		System.out.println(sol.maxPathSum(root));
	}
}
