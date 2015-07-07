## [Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/)

### Problem

Reverse a singly linked list.

__Hint:__

A linked list can be reversed either iteratively or recursively. Could you implement both?

### Solution


### Code

``` Python
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param {ListNode} head
    # @return {ListNode}
    def reverseList(self, head):
        # return self.reverseIteratively(head)

        # head, tail = self.reverseRecursively(head)
        # return head

        dummy = ListNode(0)
        dummy.next = head
        return self.reverseIterativelyWithDummy(dummy)

    def reverseIteratively(self, head):
        if head is None or head.next is None:
            return head
        p, q = head.next, head
        head.next = None
        while p is not None:
            r = p.next
            p.next = q
            q, p = p, r
        return q

    def reverseRecursively(self, head):
        if head is None or head.next is None:
            return head, head
        else:
            nHead, tail = self.reverseRecursively(head.next)
            tail.next = head
            head.next = None
            return nHead, head

    def reverseIterativelyWithDummy(self, dummy):
        p, q = dummy.next, None
        while p is not None:
            dummy.next = p.next
            p.next = q
            p, q = dummy.next, p
        return q
```

### Refinement
