## [Sort List](https://leetcode.com/problems/sort-list/)

### Problem

Sort a linked list in O(n log n) time using constant space complexity.

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
}
```

### Refinement
