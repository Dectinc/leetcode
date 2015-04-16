## [Insertion Sort List](https://leetcode.com/problems/insertion-sort-list/)

### Problem

Sort a linked list using insertion sort.

### Solution


### Code

``` Java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
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
}
```

### Refinement
