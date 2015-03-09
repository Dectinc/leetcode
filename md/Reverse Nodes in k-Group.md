## [Reverse Nodes in k-Group](https://leetcode.com/problems/reverse-nodes-in-k-group/)

### Problem

Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,

Given this linked list: `1->2->3->4->5`

For k = 2, you should return: `2->1->4->3->5`

For k = 3, you should return: `3->2->1->4->5`

### Solution

one pass, O(n) solution

- _tmp point to the node before (0, ..., k-1) segment

- _head, p point to the first node in (0, ..., k-1) segment, q will travel in the process

- t point to the last node in (0, ..., k-1) segment

### Code

``` Python
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param head, a ListNode
    # @param k, an integer
    # @return a ListNode
    def reverseKGroup(self, head, k):
        if not head or k <= 1:
            return head
        p = head
        q = head
        t = head
        _head = head
        _tmp = head
        while True:
            i = 1
            while t is not None and i < k:
                t = t.next
                i += 1
            if not t or i < k:
                break
            while p != t:
                q = p.next
                p.next = t.next
                t.next = p
                p = q

            if _head == head:
                head = p
            else:
                _tmp.next = p
            _tmp = _head
            p = q = t = _head = _head.next
        return head
```

### Refinement
