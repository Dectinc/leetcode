## [Linked List Cycle](https://oj.leetcode.com/problems/linked-list-cycle/)

### Problem

Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?

### Solution

Use two pointers

### Code

``` python
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution:
    # @param head, a ListNode
    # @return a boolean
    def hasCycle(self, head):
        init = False
        step_one = head
        step_two = head
        while step_one is not None and step_two is not None:
            if init and step_one == step_two:
                return True
            init = True
            step_one = step_one.next
            step_two = step_two.next
            if step_two is None:
                return False
            step_two = step_two.next
        return False

```

### Refinement
