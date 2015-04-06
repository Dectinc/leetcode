/**
 * 
 */
package cc.dectinc.leetcode;

import cc.dectinc.leetcode.structs.TreeLinkNode;

/**
 * @author Dectinc
 * @version Apr 4, 2015 11:53:45 PM
 * 
 */
public class PopulatingNextRightPointersInEachNode2 {
	public void connect(TreeLinkNode root) {
		while (root != null) {
			TreeLinkNode tempChild = new TreeLinkNode(0);
			TreeLinkNode currentChild = tempChild;
			while (root != null) {
				if (root.left != null) {
					currentChild.next = root.left;
					currentChild = currentChild.next;
				}
				if (root.right != null) {
					currentChild.next = root.right;
					currentChild = currentChild.next;
				}
				root = root.next;
			}
			root = tempChild.next;
		}
	}
}
