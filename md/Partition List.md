## [Partition List](https://leetcode.com/problems/partition-list/)

### Problem

Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,

Given `1->4->3->2->5->2` and x = 3,

return `1->2->2->4->3->5`. 


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
    # @param x, an integer
    # @return a ListNode
    def partition(self, head, x):
        p = headLeft = ListNode(0) 
        q = headRight = ListNode(0)
        cur = head
        while cur is not None:
            r = cur
            cur = cur.next
            r.next = None
            if r.val < x:
                p.next = r
                p = p.next
            else:
                q.next = r
                q = q.next
            r = r.next
        p.next = headRight.next
        return headLeft.next
```

### Refinement
