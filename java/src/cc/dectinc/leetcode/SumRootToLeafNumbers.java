/**
 * 
 */
package cc.dectinc.leetcode;

import cc.dectinc.api.structs.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Dectinc
 * @version Apr 10, 2015 12:16:50 AM
 * 
 */
public class SumRootToLeafNumbers {
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

	public static void main(String[] args) {
		SumRootToLeafNumbers sol = new SumRootToLeafNumbers();
		TreeNode root = TreeNode.constructTreeWithLevelTraversal(new Integer[] {
				1, 2, 3 });
		System.out.println(sol.sumNumbers(root));
	}
}
