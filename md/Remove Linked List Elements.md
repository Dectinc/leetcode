## [Remove Linked List Elements](https://leetcode.com/problems/remove-linked-list-elements/)

### Problem

Remove all elements from a linked list of integers that have value __val__.

__Example__

__Given__: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, __val__ = 6

__Return__: 1 --> 2 --> 3 --> 4 --> 5

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
    # @param {integer} val
    # @return {ListNode}
    def removeElements(self, head, val):
        dummy = ListNode(0)
        dummy.next = head
        p = dummy.next
        q = dummy
        
        while p is not None:
            if p.val == val:
                q.next = p.next
            else:
                q = q.next
            p = p.next
            
        return dummy.next
```

### Refinement
