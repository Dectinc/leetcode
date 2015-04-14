/**
 * 
 */

package cc.dectinc.leetcode;

import cc.dectinc.api.structs.ListNode;

/**
 * @author chenshijiang
 * @date Apr 14, 2015 10:03:44 AM
 * 
 */
public class LinkedListCycle2 {
	public ListNode detectCycle(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode slow = head;
		ListNode fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast) {
				fast = head;
				slow = slow.next;
				while (slow != fast) {
					slow = slow.next;
					fast = fast.next;
				}
				return slow;
			}
		}
		return null;
	}

	public static void main(String[] args) {
		LinkedListCycle2 sol = new LinkedListCycle2();
		ListNode head = ListNode.constructList(new Integer[] { 1, 2 });
		head.next.next = head;
		System.out.println(sol.detectCycle(head));
	}
}
