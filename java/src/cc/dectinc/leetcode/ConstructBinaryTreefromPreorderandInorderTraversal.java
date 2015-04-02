package cc.dectinc.leetcode;

import cc.dectinc.leetcode.structs.TreeNode;

/**
 * @author Dectinc (i@dectinc.cc)
 * @date 15-04-02 00:31
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public ConstructBinaryTreeFromPreorderAndInorderTraversal() {
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, preorder.length, 0, inorder.length);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart == preEnd && inStart == inEnd) {
            return null;
        }
        int rootValue = preorder[preStart];
        TreeNode curRoot = new TreeNode(rootValue);
        int rootIndex = inorder.
        return null;
    }

    public static void main(String args[]) {
    }
}
