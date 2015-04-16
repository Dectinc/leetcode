/**
 * 
 */
package cc.dectinc.leetcode;

import cc.dectinc.api.structs.ListNode;

/**
 * @author Dectinc
 * @version Apr 15, 2015 4:52:43 PM
 * 
 */
public class ReorderList {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null) {
			return;
		}
		// get last half using fast and slow
		ListNode p = head, q = head.next;
		while (q != null && q.next != null) {
			p = p.next;
			q = q.next.next;
		}
		q = p.next;
		p.next = null;
		p = head;

		q = reverseList(q);

		ListNode t;
		while (p != null) {
			t = p.next;
			p.next = q;
			p = t;
			if (q != null) {
				t = q.next;
				q.next = p;
				q = t;
			}
		}
	}

	public ListNode reverseList(ListNode head) {
		ListNode root = new ListNode(0);
		root.next = head;
		ListNode p, q, t;
		p = t = root.next;
		q = p.next;

		while (q != null) {
			t.next = q.next;
			root.next = q;
			q.next = p;
			p = q;
			q = t.next;
		}

		return root.next;
	}

	public static void main(String[] args) {
		ReorderList sol = new ReorderList();
		ListNode head = ListNode.constructList(new Integer[] { 1, 2, 3, 4, 5 });
		sol.reorderList(head);
		System.out.println(ListNode.convertLinkedListToList(head));
	}
}
