package cc.dectinc.leetcode;

import cc.dectinc.leetcode.structs.TreeNode;

import java.util.HashMap;

/**
 * @author Dectinc (i@dectinc.cc)
 * @date 2015-04-02 12:41 PM
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    HashMap<Integer, Integer> indexMap = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = inorder.length;
        for (int i = 0; i < length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, preorder.length-1, 0, length-1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (preStart > preEnd && inStart > inEnd) {
            return null;
        }
        int rootValue = preorder[preStart];
        TreeNode curRoot = new TreeNode(rootValue);
        int rootIndex = indexMap.get(rootValue);
        curRoot.left = buildTree(preorder, inorder, preStart+1, preStart+rootIndex-inStart, inStart, rootIndex-1);
        curRoot.right = buildTree(preorder, inorder, preStart+rootIndex-inStart+1, preEnd, rootIndex+1, inEnd);
        return curRoot;
    }

    public static void main(String args[]) {
    }
}
