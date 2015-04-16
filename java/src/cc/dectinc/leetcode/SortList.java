/**
 * 
 */
package cc.dectinc.leetcode;

import cc.dectinc.api.structs.ListNode;

/**
 * @author Dectinc
 * @version Apr 16, 2015 9:46:01 PM
 * 
 */
public class SortList {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode fast = head.next;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		fast = slow.next;
		slow.next = null;
		head = sortList(head);
		fast = sortList(fast);
		return merge(head, fast);
	}

	private ListNode merge(ListNode head1, ListNode head2) {
		ListNode dummy = new ListNode(0);
		ListNode p = dummy;
		while (head1 != null && head2 != null) {
			if (head1.val > head2.val) {
				p.next = head2;
				head2 = head2.next;
			} else {
				p.next = head1;
				head1 = head1.next;
			}
			p = p.next;
		}
		if (head1 != null) {
			p.next = head1;
		}
		if (head2 != null) {
			p.next = head2;
		}
		return dummy.next;
	}

	private void quickSortList(ListNode head, ListNode tail) {
		if (head == null || head.next == null) {
			return;
		}
		int val = head.val;
		ListNode r = head.next;
		ListNode p = new ListNode(0), dummy1 = p;
		ListNode q = new ListNode(0), dummy2 = q;
		while (r != tail) {
			if (r.val < val) {
				p.next = r;
				p = r;
			} else {
				q.next = r;
				q = r;
			}
			r = r.next;
		}
		p.next = head;
		head.next = dummy2.next;
		q.next = tail;
		head = dummy1.next;
		quickSortList(dummy1.next, p);
		quickSortList(dummy2.next, tail);
	}

	private void swapNodes(ListNode p, ListNode q) {
		ListNode r = p;
		p = q;
		q = r;
	}

	public static void main(String[] args) {
		SortList sol = new SortList();
		ListNode head = ListNode
				.constructList(new Integer[] { 5, 1, 4, 0, 3, 2 });
		System.out.println(sol.sortList(head));
		// ListNode head1 = ListNode.constructList(new Integer[] { 1, 3, 5 });
		// ListNode head2 = ListNode.constructList(new Integer[] { 1, 2, 4, 6
		// });
		// System.out.println(sol.merge(head1, head2));
	}
}
