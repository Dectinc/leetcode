## [Merge Two Sorted Lists](https://oj.leetcode.com/problems/merge-two-sorted-lists/)

### Problem

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

### Solution


### Code

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null, p = head, q = p;
        while (l1 != null && l2 != null) {
            q = p;
            int val1 = l1 == null ? Integer.MIN_VALUE : l1.val;
            int val2 = l2 == null ? Integer.MIN_VALUE : l2.val;
            if (val1 <= val2) {
                p = l1;
                l1 = l1.next;
            } else {
                p = l2;
                l2 = l2.next;
            }
            if (head == null) {
                head = p;
            } else {
                q.next = p;
            }
        }
        q = p;
        if (l1 != null || l2 != null) {
            if (l1 != null) {
                p = l1;
            } else {
                p = l2;
            }
            if (head == null) {
                head = p;
            } else {
                q.next = p;
            }
        }
        return head;
    }
}
```

### Refinement