package cc.dectinc.leetcode;

import cc.dectinc.leetcode.structs.TreeNode;

import java.util.HashMap;

/**
 * @author Dectinc (i@dectinc.cc)
 * @date 2015-04-02 13:07 PM
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    HashMap<Integer, Integer> indexMap = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int length = inorder.length;
        for (int i = 0; i < length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(inorder, postorder, 0, length-1, 0, postorder.length-1);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        int rootValue = postorder[postEnd];
        TreeNode curRoot = new TreeNode(rootValue);
        int rootIndex = indexMap.get(rootValue);
        curRoot.left = buildTree(inorder, postorder, inStart, rootIndex-1, postStart, postStart+rootIndex-inStart-1);
        curRoot.right = buildTree(inorder, postorder, rootIndex+1, inEnd, postStart+rootIndex-inStart, postEnd-1);
        return curRoot;
    }

    public static void main(String args[]) {
    }
}
