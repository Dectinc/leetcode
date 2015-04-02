package cc.dectinc.leetcode;

import cc.dectinc.leetcode.structs.ListNode;
import cc.dectinc.leetcode.structs.TreeNode;

/**
 * @author Dectinc (i@dectinc.cc)
 * @date 2015-04-02 14:13 PM
 */
public class ConvertSortedListToBinarySearchTree {
    public ConvertSortedListToBinarySearchTree() {
    }

    public TreeNode sortedListToBST(ListNode head) {
        return buildBST(head, null);
    }

    public TreeNode buildBST(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = buildBST(head, slow);
        root.right = buildBST(slow.next, tail);
        return root;
    }

    public static void main(String args[]) {
    }
}
