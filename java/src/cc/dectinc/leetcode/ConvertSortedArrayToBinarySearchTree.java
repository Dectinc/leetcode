package cc.dectinc.leetcode;

import cc.dectinc.leetcode.structs.TreeNode;

/**
 * @author Dectinc (i@dectinc.cc)
 * @date 2015-04-02 13:20 PM
 */
public class ConvertSortedArrayToBinarySearchTree {
    public ConvertSortedArrayToBinarySearchTree() {
    }

    public TreeNode sortedArrayToBST(int[] num) {
        return buildBST(num, 0, num.length-1);
    }

    public TreeNode buildBST(int[] num, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start+end+1)/2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = buildBST(num, start, mid-1);
        root.right = buildBST(num, mid+1, end);
        return root;
    }

    public static void main(String args[]) {
    }
}
