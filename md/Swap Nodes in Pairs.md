## [Swap Nodes in Pairs](http://oj.leetcode.com/problems/swap-nodes-in-pairs/)

**Problem**

Given a linked list, swap every two adjacent nodes and return its head.

For example,

Given `1->2->3->4`, you should return the list as `2->1->4->3`.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

**Solution**


**Code**

``` java
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

	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode p = new ListNode(0);
		p.next = head;
		head = p;
		while (p.next != null && p.next.next != null) {
			p.next = swapListNode(p.next, p.next.next);
			p = p.next.next;
		}

		return head.next;
	}

	private ListNode swapListNode(ListNode l1, ListNode l2) {
		l1.next = l2.next;
		l2.next = l1;
		return l2;
	}
}
```

**Refinement**