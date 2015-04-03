package cc.dectinc.leetcode;

import cc.dectinc.leetcode.structs.TreeNode;

import java.util.Stack;

/**
 * @author Dectinc (i@dectinc.cc)
 * @date 15-04-02 22:05
 */
public class FlattenBinaryTreeToLinkedList {
    public FlattenBinaryTreeToLinkedList() {
    }

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode lastNode = new TreeNode(0);
        Stack<TreeNode> nodes = new Stack<TreeNode>();
        nodes.push(root);
        while (!nodes.empty()) {
            TreeNode node = nodes.pop();
            lastNode.right = node;
            if (node.right != null) {
                nodes.push(node.right);
            }
            if (node.left != null) {
                nodes.push(node.left);
            }
            node.left = null;
            node.right = null;
            lastNode = node;
        }
    }

    public static void main(String args[]) {
    }
}
