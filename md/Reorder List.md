## [Reorder List](https://leetcode.com/problems/reorder-list/)

### Problem

Given a singly linked list L: L0→L1→…→Ln-1→Ln,

reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,

Given `{1,2,3,4}`, reorder it to `{1,4,2,3}`.

### Solution


### Code

``` Java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
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
}
```

### Refinement
