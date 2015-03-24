## [Remove Duplicates from Sorted List II](https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/)

### Problem

Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,

Given `1->2->3->3->4->4->5`, return `1->2->5`.

Given `1->1->1->2->3`, return `2->3`. 

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
    # @return a ListNode
    def deleteDuplicates(self, head):
        dummyHead = ListNode(0)
        dummyHead.next = head
        last = dummyHead

        while last and last.next:
            if last.next and last.next.next and last.next.val == last.next.next.val:
                self.removeDuplicate(last)
            else:
                last = last.next

        return dummyHead.next

    def removeDuplicate(self, last):
        start = last.next
        end = last.next.next
        while end.next:
            if end.next.val != start.val:
                break
            end = end.next

        last.next = end.next
```

### Refinement
