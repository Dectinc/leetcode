/**
 *
 */
package cc.dectinc.leetcode;

import cc.dectinc.api.structs.TreeNode;

import java.util.Stack;

/**
 * @author Dectinc
 * @version Apr 20, 2015 9:12:30 PM
 */
public class BSTIterator {
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        allLeftIntoStack(root);
    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return stack.size() > 0;
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        TreeNode node = stack.pop();
        allLeftIntoStack(node.right);
        return node.val;
    }

    private void allLeftIntoStack(TreeNode node) {
        while (node != null) {
            stack.add(node);
            node = node.left;
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.constructTreeWithLevelTraversal(new Integer[]{
                2, 1});
        BSTIterator iter = new BSTIterator(root);
        while (iter.hasNext()) {
            System.out.print("" + iter.next() + "\t");
        }
    }
}
