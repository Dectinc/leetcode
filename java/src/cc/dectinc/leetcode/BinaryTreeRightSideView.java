/**
 * 
 */
package cc.dectinc.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import cc.dectinc.api.structs.TreeNode;

/**
 * @author Dectinc
 * @version Apr 21, 2015 12:32:09 AM
 * 
 */
public class BinaryTreeRightSideView {
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

	public static void main(String[] args) {
		BinaryTreeRightSideView sol = new BinaryTreeRightSideView();
		TreeNode root = TreeNode.constructTreeWithLevelTraversal(new Integer[] {
				1, 2, 3, null, 5 });
		System.out.println(sol.rightSideView(root));
	}

}
