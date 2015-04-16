/**
 * 
 */
package cc.dectinc.leetcode;

import cc.dectinc.api.structs.ListNode;

/**
 * @author Dectinc
 * @version Apr 16, 2015 9:26:01 PM
 * 
 */
public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode q = head.next, t = head;
		ListNode p, r;

		while (q != null) {
			r = dummy;
			p = dummy.next;
			int val = q.val;
			while (p != q && val > p.val) {
				r = p;
				p = p.next;
			}
			if (p == q) {
				q = q.next;
				t = t.next;
			} else {
				t.next = q.next;
				q.next = p;
				r.next = q;
				q = t.next;
			}
		}

		return dummy.next;
	}

	public static void main(String[] args) {
		InsertionSortList sol = new InsertionSortList();
		ListNode head = ListNode
				.constructList(new Integer[] { 5, 1, 4, 0, 3, 2 });
		System.out.println(sol.insertionSortList(head));
	}

}
