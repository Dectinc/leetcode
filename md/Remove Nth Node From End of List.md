## [Remove Nth Node From End of List](https://oj.leetcode.com/problems/remove-nth-node-from-end-of-list/)

### Problem

Given a linked list, remove the nth node from the end of list and return its head.

For example,
```
   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
```

__Note__:

Given _n_ will always be valid.

Try to do this in one pass.

### Solution


### Code

``` Python
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @return a ListNode
    def removeNthFromEnd(self, head, n):
        if n < 1:
            return head
        nHead = head
        p = head
        while n > 0 and p is not None:
            p = p.next
            n -= 1
        if n > 0:
            return nHead
        node = head
        preNode = None
        while p is not None:
            preNode = node
            node = node.next
            p = p.next
        if node == head:
            return node.next
        else:
            preNode.next = node.next
            return nHead
```

### Refinement
