package cc.dectinc.leetcode;

import cc.dectinc.leetcode.structs.TreeNode;

/**
 * @author Dectinc (i@dectinc.cc)
 * @date 15-04-01 23:01
 */
public class PartitionList {
    TreeNode firstNode = null;
    TreeNode secondNode = null;
    TreeNode preNode = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        inorderTraversal(root);
        int temp = firstNode.val;
        firstNode.val = secondNode.val;
        secondNode.val = temp;
    }

    public void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        if (firstNode == null && preNode.val >= root.val) {
            firstNode = preNode;
        }
        if (firstNode != null && preNode.val >= root.val) {
            secondNode = root;
        }
        preNode = root;
        inorderTraversal(root.right);
    }

    public static void main(String args[]) {
    }
}
