## [Remove Duplicates from Sorted List](https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/)

### Problem

Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,

Given `1->1->2`, return `1->2`.

Given `1->1->2->3->3`https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/, return `1->2->3`.

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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head, q = p.next;
        while (q != null) {
            if (q.val == p.val) {
                p.next = q.next;
                q = p.next;
            } else {
                p = p.next;
                q = q.next;
            }
        }
        return head;
    }
}
```

### Refinement