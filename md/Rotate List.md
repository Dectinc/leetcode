## [Rotate List](https://leetcode.com/problems/rotate-list/)

### Problem

Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given `1->2->3->4->5->NULL` and k = `2`,
return `4->5->1->2->3->NULL`.

### Solution


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
    def rotateRight(self, head, k):
        if head is None or head.next is None or k == 0:
            return head
        p = head
        tail = p
        length = 0
        while p is not None:
            tail = p
            p = p.next
            length += 1
        k = length - k%length
        if k == length:
            return head
        p = head
        q = None
        while k != 0:
            q = p
            p = p.next
            k -= 1
        if q is not None:
            q.next = None
            tail.next = head
        return p

```

### Refinement
